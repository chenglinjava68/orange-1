package com.jq.orange.node;

import com.jq.orange.Context;
import com.jq.orange.token.TokenHandler;
import com.jq.orange.token.TokenParser;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 15:57
 **/
public class TextSqlNode implements SqlNode {

    String text;

    public TextSqlNode(String text) {
        this.text = text;
    }

    @Override
    public void apply(Context context) {
        //解析常量值 ${xxx}
        TokenParser tokenParser = new TokenParser("${", "}", new TokenHandler() {
            @Override
            public String handleToken(String paramName) {
                Object value = context.getOgnlValue(paramName);
                return value == null ? "" : value.toString();
            }
        });
        String s = tokenParser.parse(text);
        context.appendSql(s);

    }
}
