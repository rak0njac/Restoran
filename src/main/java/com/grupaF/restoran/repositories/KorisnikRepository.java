package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findByUsernameAndPassword(String username, String password);
    Optional<Korisnik> findByUsername(String username);

 @Modifying
 @Query("UPDATE Korisnik k SET k.adresa=?1, k.telefon=?2, k.email=?3, k.prezime=?4 WHERE k.iDKorisnik = ?5")
 int editQuery(String adresa, String telefon, String email, String prezime, Long iDKorisnik);


}
