package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface KorisnikRepository extends JpaRepository<korisnik, Long> {

    Optional<korisnik> findByUsernameAndPassword(String username, String password);
//
//    List<Korisnik> findByEmail(String email);
//
//    void delete(Korisnik korisnik);
//
//    void deleteById(Long iDKorisnik);
}
