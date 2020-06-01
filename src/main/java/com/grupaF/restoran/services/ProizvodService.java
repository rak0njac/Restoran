package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Proizvod;

import java.util.List;

public interface ProizvodService {

    List<Proizvod> findByNaziv(String naziv);

    List<Proizvod> findByVrsta(String vrsta);

    void delete(Proizvod proizvod);

    void insert(Proizvod proizvod);

    void edit(Proizvod proizvod);
}
