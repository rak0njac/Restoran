package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {

    List<Porudzbina> findByIDPorudzbina(int iDPorudzbina);

    List<Porudzbina> findByKorisnik(int iDKorisnik);

    @Override
    void delete(Porudzbina porudzbina);

    void insert(Porudzbina porudzbina);
}
