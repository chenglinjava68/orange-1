package com.github.freakchick.orange.tag;

import com.github.freakchick.orange.node.MixedSqlNode;
import com.github.freakchick.orange.node.SqlNode;
import com.github.freakchick.orange.node.WhereSqlNode;
import org.dom4j.Element;

import java.util.List;


public class WhereHandler implements TagHandler{

    @Override
    public void handle(Element element, List<SqlNode> targetContents) {
        List<SqlNode> contents = XmlParser.parseElement(element);

        WhereSqlNode node = new WhereSqlNode(new MixedSqlNode(contents));
        targetContents.add(node);
    }
}
