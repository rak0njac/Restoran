package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {

    List<Proizvod> findByNaziv(String naziv);

    List<Proizvod> findByVrsta(String vrsta);

    void deleteById(Long iDProizvod);
    //
}
