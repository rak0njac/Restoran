package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

    List<Korisnik> finBykorisnikId(int iDKorisnik);

    List<Korisnik> findByUserNameAndPassword(String username, String password);

    @Override
    void delete(Korisnik korisnik);

    void insert(Korisnik korisnik);

    void edit(Korisnik korisnik);
}
