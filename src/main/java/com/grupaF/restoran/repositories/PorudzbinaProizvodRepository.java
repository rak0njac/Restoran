package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Porudzbina_proizvod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PorudzbinaProizvodRepository extends JpaRepository<Porudzbina_proizvod, Long> {

    //List<Porudzbina_proizvod> findById(int iD);

    //List<Porudzbina_proizvod> findAll();

    //void insert(Porudzbina_proizvod pp);

    //void deleteById(Long iDPorudzbina);
}
