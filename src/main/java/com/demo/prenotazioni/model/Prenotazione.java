package com.demo.prenotazioni.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String utente;
    private Date dataPrenotazione;
    private String descrizione;
}
