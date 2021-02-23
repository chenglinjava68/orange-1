package com.jq.orange.node;

import com.jq.orange.context.Context;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 15:56
 **/
public class IfSqlNode implements SqlNode {

    String test;

    SqlNode contents;

    public IfSqlNode(String test, SqlNode contents) {
        this.test = test;
        this.contents = contents;
    }

    @Override
    public void apply(Context context) {
        Boolean value = context.getOgnlBooleanValue(test);
        if (value) {
            contents.apply(context);
        }

    }
}
