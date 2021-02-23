package com.jq.orange.tag;

import com.jq.orange.node.SqlNode;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

public interface TagHandler {

    void handle(Element element, List<SqlNode> contents);
}
