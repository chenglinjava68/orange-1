package com.jq.orange.tag;

import com.jq.orange.node.MixedSqlNode;
import com.jq.orange.node.SetSqlNode;
import com.jq.orange.node.SqlNode;
import org.dom4j.Element;

import java.util.List;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-25 10:41
 **/
public class SetHandler implements TagHandler{

    @Override
    public void handle(Element element, List<SqlNode> targetContents) {
        List<SqlNode> contents = XmlParser.parseElement(element);

        SetSqlNode node = new SetSqlNode(new MixedSqlNode(contents));
        targetContents.add(node);
    }
}
