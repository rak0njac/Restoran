package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findByUsernameAndPassword(String username, String password);

    List<Korisnik> findByEmail(String email);

}
