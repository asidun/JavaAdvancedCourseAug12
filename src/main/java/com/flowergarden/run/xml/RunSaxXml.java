package com.flowergarden.run.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RunSaxXml {

	public static void main(String[] args) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {

				public void startElement(String uri, String localName, String qName, Attributes attributes)
						throws SAXException {
					System.out.println("Start Element :" + qName);
					
					for (int i = 0; i < attributes.getLength(); i++) {
						System.out.println(attributes.getQName(i)+" "+attributes.getValue(i));
					}
				}

//				public void endElement(String uri, String localName, String qName) throws SAXException {
//					System.out.println("End Element :" + qName);
//				}

//				public void characters(char ch[], int start, int length) throws SAXException {
//					System.out.println(ch.length);
//					if (length > 0)
//						System.out.println("Characters : " + new String(ch, start, length));
//				}
			};

			saxParser.parse("xmlstore/roses.xml", handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
