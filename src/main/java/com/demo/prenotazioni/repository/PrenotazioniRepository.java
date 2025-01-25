package com.demo.prenotazioni.repository;

import com.demo.prenotazioni.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioniRepository extends JpaRepository<Prenotazione, Long> {
}
