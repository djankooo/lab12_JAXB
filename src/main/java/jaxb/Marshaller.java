package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;

public class Marshaller {

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
}