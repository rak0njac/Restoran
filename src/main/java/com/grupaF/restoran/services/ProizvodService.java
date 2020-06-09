package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Proizvod;

import java.util.List;
import java.util.Optional;

public interface ProizvodService {

    List<Proizvod> findByNaziv(String naziv);

    List<Proizvod> findByVrsta(String vrsta);

    List<Proizvod> findAll();

    void delete(Long id);

    void deleteById(Long iDProizvod);

    Proizvod insert(Proizvod proizvod);

    Optional<Proizvod> findById(Long id);

    Proizvod edit(Proizvod proizvod);
}
