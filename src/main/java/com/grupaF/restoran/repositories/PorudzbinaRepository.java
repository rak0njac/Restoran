package com.grupaF.restoran.repositories;

import com.grupaF.restoran.models.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {

    List<Porudzbina> findByDatum(Date datum);

    void deleteById(Long iDPorudzbina);
}
