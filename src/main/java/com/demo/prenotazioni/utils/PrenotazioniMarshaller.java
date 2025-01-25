package com.demo.prenotazioni.utils;

import com.demo.prenotazioni.model.Prenotazioni;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.StringWriter;

public class PrenotazioniMarshaller {

    private static JAXBContext context = null;

    static {
        try {
            context = JAXBContext.newInstance(Prenotazioni.class);
        } catch (JAXBException e) {
            throw new RuntimeException(String.format("error instantiating context: %s",e.getMessage()));
        }
    }

    public static String marshal(Prenotazioni prenotazioni) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        StringWriter sw = new StringWriter();
        marshaller.marshal(prenotazioni, sw);
        return sw.toString();
    }
}
