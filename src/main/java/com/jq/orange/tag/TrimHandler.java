package com.jq.orange.tag;

import com.jq.orange.node.MixedSqlNode;
import com.jq.orange.node.SqlNode;
import com.jq.orange.node.TrimSqlNode;
import org.dom4j.Element;

import java.util.Arrays;
import java.util.List;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-24 11:20
 **/
public class TrimHandler implements TagHandler {

    @Override
    public void handle(Element element, List<SqlNode> targetContents) {
        String prefix = element.attributeValue("prefix");
        String suffix = element.attributeValue("suffix");
        String prefixesToOverride = element.attributeValue("prefixesToOverride");
        List<String> prefixesOverride = prefixesToOverride == null ? null : Arrays.asList(prefixesToOverride.split("\\|"));
        String suffixesToOverride = element.attributeValue("suffixesToOverride");
        List<String> suffixesOverride = suffixesToOverride == null ? null : Arrays.asList(suffixesToOverride.split("\\|"));

        List<SqlNode> contents = XmlParser.parseElement(element);
        TrimSqlNode trimSqlNode = new TrimSqlNode(new MixedSqlNode(contents), prefix, suffix, prefixesOverride, suffixesOverride);
        targetContents.add(trimSqlNode);
    }
}
