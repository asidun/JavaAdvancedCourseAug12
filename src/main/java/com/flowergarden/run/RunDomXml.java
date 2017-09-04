package com.flowergarden.run;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import sun.plugin.dom.core.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by olena.kruchina on 8/25/2017.
 */
public class RunDomXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //создали фабрику строителей, сложный и громоздкий процесс (пореже        выполняйте это действие)
        // f.setValidating(false); // не делать проверку валидации
        DocumentBuilder db = dbf.newDocumentBuilder(); // создали        конкретного строителя документа
        Document doc = db.parse(new File("src/main/resources/bouquet/roses.xml")); // стооитель        построил документ
//Document - тоже является нодом, и импленментирует методы
//        visit(doc, 0);
        printRoses(doc);

    }

    public static void printRoses(Node node) {
        NodeList list = node.getChildNodes(); //will be <roses>
        list = list.item(0).getChildNodes(); //children of <roses>
        for (int i = 0; i < list.getLength(); i++) {
            NamedNodeMap attrs = list.item(i).getAttributes();
            for (int j = 0; j < attrs.getLength(); j++) {
                System.out.println(attrs.item(0));
            }
        }
    }

    public static void visit(Node node, int level) {
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i); // текущий нод
            process(childNode, level + 1); // обработка
            visit(childNode, level + 1); // рекурсия
        }
    }

    public static void process(Node node, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print('\t');
        }
        System.out.print(node.getNodeName() + " ");
        if (node instanceof Element) {
            Element e = (Element) node;// работаем как с элементом (у него есть атрибуты и схема)
            NamedNodeMap attrs = e.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++)
                System.out.println(attrs.item(i).getNodeName() + "-" + attrs.item(i).getNodeValue() + " ");
        }
        System.out.println();
    }
}
