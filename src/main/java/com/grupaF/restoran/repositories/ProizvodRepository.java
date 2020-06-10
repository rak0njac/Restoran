package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

    List<Proizvod> findByNaziv(String naziv);

    List<Proizvod> findByVrsta(String vrsta);

    void deleteById(Long iDProizvod);
    //
    @Modifying
    @Query("UPDATE Proizvod p SET p.cena=?1, p.opis=?2, p.slika=?3, p.naziv=?4 WHERE p.iDProizvod = ?5")
    int editQuery(int cena, String opis, String slika, String naziv, Long iDProizvod);
}
