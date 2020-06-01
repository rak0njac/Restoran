package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PorudzbinaService {

    List<Porudzbina> findByDatum(Date date);
    Optional<Porudzbina> findByIDPorudzbina(Long id);

    public void insert(Porudzbina porudzbina);
    public void delete(Porudzbina porudzbina);

}
