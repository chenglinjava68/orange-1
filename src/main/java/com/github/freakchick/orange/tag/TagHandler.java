package com.github.freakchick.orange.tag;

import com.github.freakchick.orange.node.SqlNode;
import org.dom4j.Element;

import java.util.List;

public interface TagHandler {

    void handle(Element element, List<SqlNode> contents);
}
