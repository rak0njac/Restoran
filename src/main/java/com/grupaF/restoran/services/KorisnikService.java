package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;

import java.util.List;

public interface KorisnikService {
    List<Korisnik> finBykorisnikId(int iDKorisnik);

    List<Korisnik> findByUserNameAndPassword(String username, String password);

    void delete(Korisnik korisnik);

    void insert(Korisnik korisnik);

    void edit(Korisnik korisnik);
}

