package com.jq.orange.node;

import com.jq.orange.context.Context;

import java.util.Set;


public interface SqlNode {

    void apply(Context context);

    void applyParameter(Set<String> set);

}
