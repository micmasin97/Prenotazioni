package com.demo.prenotazioni.service;

import com.demo.prenotazioni.model.Prenotazione;
import jakarta.xml.bind.JAXBException;

import java.util.List;

public interface PrenotazioniService {
    Prenotazione readPrenotazione(long id);
    List<Prenotazione> readPrenotazione();
    String readPrenotazioni() throws JAXBException;
    Prenotazione writePrenotazione(Prenotazione prenotazione);
}
