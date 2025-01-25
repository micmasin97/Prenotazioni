package com.demo.prenotazioni.model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Prenotazioni {
    private List<Prenotazione> prenotazioni;

    public List<Prenotazione> getPrenotazioni() {
        if(prenotazioni == null) {
            prenotazioni = new ArrayList<>();
        }
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}
