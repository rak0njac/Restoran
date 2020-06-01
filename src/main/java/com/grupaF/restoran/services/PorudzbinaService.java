package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina;

import java.util.List;
import java.util.Optional;

public interface PorudzbinaService {

    List<Porudzbina> findByDatum(Porudzbina porudzbina);
    Optional<Porudzbina> findByIDPorudzbina(Porudzbina porudzbina);

    public void insert(Porudzbina porudzbina);
    public void delete(Porudzbina porudzbina);

}
