package com.jq.orange.node;

import java.util.Arrays;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-26 14:37
 **/
public class SetSqlNode extends TrimSqlNode {

    public SetSqlNode(SqlNode contents) {
        super(contents, "SET ", null, null, Arrays.asList(","));
    }
}
