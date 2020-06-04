package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {
    Optional<Korisnik> findBykorisnikId(Long iDKorisnik);

    Optional<Korisnik>findByUsernameAndPassword(String username, String password);

    List<Korisnik>findAll();

    void delete(Korisnik korisnik);

    Korisnik insert(Korisnik korisnik);

    Korisnik edit(Korisnik korisnik);

    void deleteById(Long iDKorisnik);
}

