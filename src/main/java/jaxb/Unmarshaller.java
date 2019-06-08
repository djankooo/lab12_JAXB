package jaxb;

import jaxb_invoice.Invoice;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Unmarshaller {

    public static void main(String[] args) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Invoice.class);
        javax.xml.bind.Unmarshaller unmarshaller = ctx.createUnmarshaller();

        Invoice product = (Invoice) unmarshaller.unmarshal(new File("invoice.xml"));
        System.out.println(product.getProduct());
    }
}