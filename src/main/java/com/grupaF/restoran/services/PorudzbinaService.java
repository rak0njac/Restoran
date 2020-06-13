package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PorudzbinaService {

    List<Porudzbina> findByDatum(Date date);
    Optional<Porudzbina> findByIDPorudzbina(Long id);

    Porudzbina insert(Porudzbina porudzbina);
    void delete(Long iDPorudzbina);

    Porudzbina edit(Porudzbina porudzbina);


    List<Porudzbina> findAll();

    void deleteById(Long iDPorudzbina);
}
