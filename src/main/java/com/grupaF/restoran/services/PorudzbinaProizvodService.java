package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina_proizvod;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PorudzbinaProizvodService {

    //List<Porudzbina> findByDatum(Date date);
    //Optional<Porudzbina> findByIDPorudzbina(Long id);

    Porudzbina_proizvod insert(Porudzbina_proizvod porudzbina_proizvod);
    //void delete(Long iDPorudzbina);
//
    //Porudzbina edit(Porudzbina porudzbina);


    List<Porudzbina_proizvod> findAll();

    //void deleteById(Long iDPorudzbina);
}
