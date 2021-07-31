package com.github.freakchick.orange.node;

import com.github.freakchick.orange.context.Context;

import java.util.Set;


public interface SqlNode {

    void apply(Context context);

    void applyParameter(Set<String> set);

}
