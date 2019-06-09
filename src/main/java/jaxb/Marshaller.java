package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Marshaller {

    //public static void main(String[] args) throws JAXBException {

        private Object o;

        Marshaller(Object o) {
            this.o = o;
        }

        public void createXML(String name) throws JAXBException {
            JAXBContext ctx = JAXBContext.newInstance(o.getClass());
            javax.xml.bind.Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, new File(name + ".xml"));
        }
//        Address payerAddress = new Address();
//        payerAddress.setStreet("payerAddressStreet");
//        payerAddress.setCity("payerAddressCity");
//
//        Address sellerAddress = new Address();
//        sellerAddress.setStreet("sellerAddress");
//        sellerAddress.setCity("sellerAddressCityStreet");
//
//        Payer payer = new Payer();
//        payer.setFirstName("payerName");
//        payer.setLastName("payerLastName");
//        payer.setAddress(payerAddress);
//        payer.setContactNo("payerNumber");
//        payer.setEmail("payer@email.com");
//
//        Seller seller = new Seller();
//        seller.setFirstName("sellerName");
//        seller.setLastName("sellerLastName");
//        seller.setAddress(sellerAddress);
//        seller.setContactNo("sellerNumber");
//        seller.setEmail("seller@email.com");
//
//        Product product = new Product();
//        product.setDescription("testProduct1");
//        product.setAmount(BigDecimal.valueOf(1.0));
//
//        Product product2 = new Product();
//        product2.setDescription("testProduct2");
//        product2.setAmount(BigDecimal.valueOf(1.0));
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceID(BigInteger.valueOf(1));
//        invoice.setPayer(payer);
//        invoice.setSeller(seller);
//        invoice.setProduct(product);
//        invoice.setProduct(product2);


    //}
}