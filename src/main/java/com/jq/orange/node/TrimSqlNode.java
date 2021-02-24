package com.jq.orange.node;

import com.jq.orange.context.Context;

import java.util.List;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-24 11:19
 **/
public class TrimSqlNode implements SqlNode{

     SqlNode contents;
     String prefix;
     String suffix;
     List<String> prefixesToOverride;
     List<String> suffixesToOverride;

    public TrimSqlNode(SqlNode contents, String prefix, String suffix, List<String> prefixesToOverride, List<String> suffixesToOverride) {
        this.contents = contents;
        this.prefix = prefix;
        this.suffix = suffix;
        this.prefixesToOverride = prefixesToOverride;
        this.suffixesToOverride = suffixesToOverride;
    }

    @Override
    public void apply(Context context) {

    }
}
