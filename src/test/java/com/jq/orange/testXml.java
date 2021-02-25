package com.jq.orange;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @program: orange
 * @description:
 * @author: jiangqiang
 * @create: 2021-02-25 15:16
 **/
public class testXml {

    @Test
    public void test() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setCoalescing(false);

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>aaa</root>");
        Node root = document.getElementsByTagName("root").item(0);
//        NodeList childNodes = root.getChildNodes();

    }
}


