package com.demo.prenotazioni.service.impl;

import com.demo.prenotazioni.exception.PrenotazioneNotFoundException;
import com.demo.prenotazioni.model.Prenotazione;
import com.demo.prenotazioni.model.Prenotazioni;
import com.demo.prenotazioni.repository.PrenotazioniRepository;
import com.demo.prenotazioni.service.PrenotazioniService;
import com.demo.prenotazioni.utils.PrenotazioniMarshaller;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniServiceImpl implements PrenotazioniService {
    private PrenotazioniRepository repository;

    @Override
    public Prenotazione readPrenotazione(long id) {
        return repository.findById(id).orElseThrow(()->new PrenotazioneNotFoundException(id));
    }
    @Override
    public List<Prenotazione> readPrenotazione() {
        return repository.findAll();
    }

    public String readPrenotazioni() throws JAXBException {
        Prenotazioni prenotazioni = new Prenotazioni();
        prenotazioni.setPrenotazioni(readPrenotazione());
        return PrenotazioniMarshaller.marshal(prenotazioni);
    }

    @Override
    public Prenotazione writePrenotazione(Prenotazione prenotazione) {
        return repository.save(prenotazione);
    }

    public PrenotazioniServiceImpl(PrenotazioniRepository repository) {
        super();
        this.repository = repository;
    }

}
