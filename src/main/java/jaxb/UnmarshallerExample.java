package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerExample {
    public static void main(String[] args) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Payer_old.class);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();

        Payer_old product = (Payer_old) unmarshaller.unmarshal(new File("product.xml"));
        System.out.println(product.getCity());
    }
}