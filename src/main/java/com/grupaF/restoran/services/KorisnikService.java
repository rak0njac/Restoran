package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    Optional<Korisnik> findById(Long iDKorisnik);

    Optional<Korisnik>findByUsernameAndPassword(String username, String password);

    List<Korisnik>findAll();

    void delete(Korisnik korisnik);

//    Korisnik insert(Korisnik korisnik);

    Korisnik save(Korisnik korisnik);

    void deleteById(Long iDKorisnik);


    int editQuery(String adresa, String telefon, String email, String prezime, Long iDKorisnik);

}

