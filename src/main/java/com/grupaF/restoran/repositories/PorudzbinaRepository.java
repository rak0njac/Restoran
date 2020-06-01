package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Integer> {

    List<Porudzbina> findByDatum(Porudzbina porudzbina);
    Optional<Porudzbina> findByIDPorudzbina(Porudzbina porudzbina);

}
