package com.flowergarden.run.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

public class RunJaxbXml {

	public static void main(String[] args) throws JAXBException {
		Rose rose = new Rose(true, 10, 15, new FreshnessInteger(1));
		saveObject(new File("xmlstore/rose1.xml"), rose);

	}

	public static void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o,file);
    }

	
}
