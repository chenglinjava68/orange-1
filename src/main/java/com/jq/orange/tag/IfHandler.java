package com.jq.orange.tag;

import com.jq.orange.node.IfSqlNode;
import com.jq.orange.node.MixedSqlNode;
import com.jq.orange.node.SqlNode;
import org.dom4j.Element;

import java.util.List;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-22 16:56
 **/
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
