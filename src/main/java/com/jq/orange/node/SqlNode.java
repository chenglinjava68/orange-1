package com.jq.orange.node;

import com.jq.orange.context.Context;

import java.util.Set;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 15:55
 **/
public interface SqlNode {

    void apply(Context context);

    void applyParameter(Set<String> set);

}
