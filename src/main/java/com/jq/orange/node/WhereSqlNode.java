package com.jq.orange.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhereSqlNode extends TrimSqlNode {

    public WhereSqlNode(SqlNode contents) {
        super(contents);
        List<String> prefixesToOverride = new ArrayList<>();
        prefixesToOverride.add("and ");
        prefixesToOverride.add("and\n");
        prefixesToOverride.add("and\r");
        prefixesToOverride.add("and\t");
        prefixesToOverride.add("or ");
        prefixesToOverride.add("or\n");
        prefixesToOverride.add("or\r");
        prefixesToOverride.add("or\t");

        List<String> suffixesToOverride = Collections.singletonList(",");
        this.prefix = "where";
        this.suffix = null;
        this.prefixesToOverride = prefixesToOverride;
        this.suffixesToOverride = suffixesToOverride;
//        super(contents, "where", null, prefixesToOverride, suffixesToOverride);
    }
}
