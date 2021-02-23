package com.jq.orange.engine;

import com.jq.orange.Context;
import com.jq.orange.node.SqlNode;
import com.jq.orange.tag.XmlParser;
import com.jq.orange.token.TokenHandler;
import com.jq.orange.token.TokenParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 18:21
 **/
public class DynamicSqlEngine {

    public void parse(String text, Map<String, Object> params) {
        SqlNode sqlNode = XmlParser.parseXml2SqlNode(text);
        Context context = new Context(params);
        parseSqlText(sqlNode, context);
        parseParameter(context);
        String sql = context.getSql();
        System.out.println(sql);
    }

    public void parseSqlText(SqlNode sqlNode, Context context) {
        sqlNode.apply(context);
    }

    public void parseParameter(Context context) {
        TokenParser tokenParser = new TokenParser("#{", "}", new TokenHandler() {
            @Override
            public String handleToken(String content) {
                Object value = context.getOgnlValue(content);
                if (value == null) {
                    throw new RuntimeException("could not found value : " + content);
                }
                context.addParameter(value);
                return "?";
            }
        });
        String sql = tokenParser.parse(context.getSql());
        context.setSql(sql);
    }

    public static void main(String[] args) {
        DynamicSqlEngine engine = new DynamicSqlEngine();
        String sql = ("<root>select <if test='minId != null'>id > ${minId} #{minId} <if test='maxId != null'> and id &lt; ${maxId} #{maxId}</if> </if></root>");
        Map<String, Object> map = new HashMap<>();
        map.put("minId", 100);
        map.put("maxId", 500);
        engine.parse(sql, map);
    }
}
