package jaxb;

import jaxb_invoice.*;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerExample {

    public static void main(String[] args) throws JAXBException {

        JAXBContext ctx = JAXBContext.newInstance(Invoice.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Address payerAddress = new Address();
        payerAddress.setStreet("payerAddressStreet");
        payerAddress.setCity("payerAddressCity");

        Address sellerAddress = new Address();
        sellerAddress.setStreet("sellerAddress");
        sellerAddress.setCity("sellerAddressCityStreet");

        Payer payer = new Payer();
        payer.setFirstName("payerName");
        payer.setLastName("payerLastName");
        payer.setAddress(payerAddress);
        payer.setContactNo("payerNumber");
        payer.setEmail("payer@email.com");

        Seller seller = new Seller();
        seller.setFirstName("sellerName");
        seller.setLastName("sellerLastName");
        seller.setAddress(sellerAddress);
        seller.setContactNo("sellerNumber");
        seller.setEmail("seller@email.com");

        Product product = new Product();
        product.setDescription("testProduct1");
        product.setAmount(BigDecimal.valueOf(1.0));

        Product product2 = new Product();
        product2.setDescription("testProduct2");
        product2.setAmount(BigDecimal.valueOf(1.0));

        Invoice invoice = new Invoice();
        invoice.setInvoiceID(BigInteger.valueOf(1));
        invoice.setPayer(payer);
        invoice.setSeller(seller);
        invoice.setProduct(product);
        invoice.setProduct(product2);

        marshaller.marshal(invoice, new File("invoice.xml"));
    }
}