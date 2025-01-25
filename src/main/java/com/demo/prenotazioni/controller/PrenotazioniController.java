package com.demo.prenotazioni.controller;

import com.demo.prenotazioni.exception.PrenotazioneNotFoundException;
import com.demo.prenotazioni.model.Prenotazione;
import com.demo.prenotazioni.service.PrenotazioniService;
import jakarta.xml.bind.JAXBException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrenotazioniController {
    private PrenotazioniService service;

    @GetMapping("/prenotazioni/{id}")
    public ResponseEntity<?> readPrenotazione(@PathVariable("id") long id) {
        ResponseEntity<?> prenotazioneResponseEntity;
        try {
            prenotazioneResponseEntity = new ResponseEntity<>(service.readPrenotazione(id), HttpStatus.OK);
        } catch(PrenotazioneNotFoundException e) {
            prenotazioneResponseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return prenotazioneResponseEntity;
    }

    @GetMapping("/prenotazioni")
    public List<Prenotazione> readPrenotazioni() {
        return service.readPrenotazione();
    }

    @PostMapping("/prenotazioni")
    public ResponseEntity<Prenotazione> writePrenotazione(@RequestBody Prenotazione prenotazione) {
        return new ResponseEntity<>(service.writePrenotazione(prenotazione), HttpStatus.CREATED);
    }

    @RequestMapping(value="/prenotazioni/export", method=RequestMethod.GET, produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> exportPrenotazioni() {
        try {
            return new ResponseEntity<>(service.readPrenotazioni(), HttpStatus.OK);
        } catch (JAXBException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public PrenotazioniController(PrenotazioniService service) {
        super();
        this.service = service;
    }
}
