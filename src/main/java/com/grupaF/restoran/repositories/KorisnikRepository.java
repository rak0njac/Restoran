package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<korisnik, Long> {

    Optional<korisnik> findByUsernameAndPassword(String username, String password);
//
//    List<Korisnik> findByEmail(String email);
//
//    void delete(Korisnik korisnik);
//
//    void deleteById(Long iDKorisnik);

 @Modifying
 @Query("UPDATE korisnik k SET k.adresa=?1, k.telefon=?2, k.email=?3, k.prezime=?4 WHERE k.iDKorisnik = ?5")
 int editQuery(String adresa, String telefon, String email, String prezime, Long iDKorisnik);


}
