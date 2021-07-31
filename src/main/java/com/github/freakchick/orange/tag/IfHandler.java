package com.github.freakchick.orange.tag;

import com.github.freakchick.orange.node.IfSqlNode;
import com.github.freakchick.orange.node.MixedSqlNode;
import com.github.freakchick.orange.node.SqlNode;
import org.dom4j.Element;

import java.util.List;


public class IfHandler implements TagHandler {

    @Override
    public void handle(Element element, List<SqlNode> targetContents) {
        String test = element.attributeValue("test");
        if (test == null) {
            throw new RuntimeException("<if> tag missing test attribute");
        }

        List<SqlNode> contents = XmlParser.parseElement(element);

        IfSqlNode ifSqlNode = new IfSqlNode(test, new MixedSqlNode(contents));
        targetContents.add(ifSqlNode);

    }
}
