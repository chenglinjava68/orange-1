package com.jq.orange.node;

import com.jq.orange.context.Context;

import java.util.List;
import java.util.Set;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 15:57
 **/
public class MixedSqlNode implements SqlNode {

    List<SqlNode> contents ;

    public MixedSqlNode(List<SqlNode> contents) {
        this.contents = contents;
    }

    @Override
    public void apply(Context context) {
        for (SqlNode node: contents){
            node.apply(context);
        }
    }

    @Override
    public void applyParameter(Set<String> set) {
        for (SqlNode node: contents){
            node.applyParameter(set);
        }
    }
}
