package jaxb;

import jaxb_invoice.Invoice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Unmarshaller {

    private String path;

    Unmarshaller(String path){
        this.path = path;
    }

    public Invoice unxml() throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(Invoice.class);
        javax.xml.bind.Unmarshaller unmarshaller = ctx.createUnmarshaller();
        Invoice i = (Invoice) unmarshaller.unmarshal(new File(path));
        System.out.println(i.getInvoiceID());
        return  i;
    }
}