package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProizvodRepository extends JpaRepository<Proizvod, Integer> {

    List<Proizvod> finByProizvodId(int iDProizvod);

    List<Proizvod> findByNaziv(String naziv);

    List<Proizvod> findByVrsta(String vrsta);

    @Override
    void delete(Proizvod proizvod);

    void insert(Proizvod proizvod);

    void edit(Proizvod proizvod);


}
