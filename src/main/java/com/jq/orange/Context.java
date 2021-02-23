package com.jq.orange;

import com.jq.orange.util.OgnlUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-20 16:05
 **/
//@Getter
public class Context {

    StringBuilder sqlBuilder = new StringBuilder();
    List<Object> jdbcParameters = new ArrayList<>();
    List<Object> jdbcParameterNames = new ArrayList<>();
    Map<String, Object> data;

    public Context(Map<String, Object> data) {
        this.data = data;
    }

    public void appendSql(String text) {
        sqlBuilder.append(text).append(" ");
    }

    public void addParameter(Object o) {
        jdbcParameters.add(o);
    }

    /**
     * 通过ognl表达式获取值
     *
     * @param expression
     * @return
     */
    public Object getOgnlValue(String expression) {
        return OgnlUtil.getValue(expression, data);
    }

    public Boolean getOgnlBooleanValue(String expression) {
        return OgnlUtil.getBooleanValue(expression, data);
    }

    public String getSql() {
        return sqlBuilder.toString();
    }

    public void setSql(String text) {
        sqlBuilder = new StringBuilder(text);
    }
}
