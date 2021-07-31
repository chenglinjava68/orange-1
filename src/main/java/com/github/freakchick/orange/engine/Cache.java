package com.github.freakchick.orange.engine;

import com.github.freakchick.orange.node.SqlNode;

import java.util.concurrent.ConcurrentHashMap;


public class Cache {

    ConcurrentHashMap<String, SqlNode> nodeCache = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, SqlNode> getNodeCache() {
        return nodeCache;
    }
}
