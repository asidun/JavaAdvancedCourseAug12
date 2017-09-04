package com.flowergarden.run;

import com.flowergarden.flowers.Rose;
import com.flowergarden.properties.FreshnessInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by olena.kruchina on 8/29/2017.
 */
public class RunJaxbXml {

    public static void main(String[] args) throws JAXBException {
        Rose rose = new Rose(true, 10, 15, new FreshnessInteger(1));
        saveObjectToXmlFile(new File("rose1.xml"), rose);
        Rose rose1 = (Rose)getObjectFromXmlFile(new File("rose1.xml"));
        System.out.println(rose1.getSpike());
        System.out.println(rose1.getFreshness());
        System.out.println(rose1.getLenght());
        System.out.println(rose1.getPrice());
    }

    public static void saveObjectToXmlFile(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(o, file);
    }

    public static Object getObjectFromXmlFile(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Rose.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(file);
    }
}
