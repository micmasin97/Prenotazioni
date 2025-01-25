package com.demo.prenotazioni.exception;

public class PrenotazioneNotFoundException extends RuntimeException{
    private long id;

    public PrenotazioneNotFoundException(long id) {
        super(String.format("Nessuna prenotazione trovata per l'id '%s'",id));
        this.id = id;
    }
}
