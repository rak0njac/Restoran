package com.grupaF.restoran.services;

import com.grupaF.restoran.models.korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    Optional<korisnik> findById(Long iDKorisnik);

    Optional<korisnik>findByUsernameAndPassword(String username, String password);

    List<korisnik>findAll();

    void delete(korisnik korisnik);

//    Korisnik insert(Korisnik korisnik);

    korisnik save(korisnik korisnik);

    void deleteById(Long iDKorisnik);
}

