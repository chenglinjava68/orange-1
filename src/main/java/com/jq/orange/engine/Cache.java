package com.jq.orange.engine;

import com.jq.orange.node.SqlNode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-24 09:18
 **/
public class Cache {

    ConcurrentHashMap<String, SqlNode> nodeCache = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, SqlNode> getNodeCache() {
        return nodeCache;
    }
}
