package jaxb;

import jaxb_invoice.Address;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerExample {
    public static void main(String[] args) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Address.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Address address = new Address();
        address.setCity("testCity");
        address.setStreet("testStreet");
        marshaller.marshal(address, new File("testAddress.xml"));
    }
}