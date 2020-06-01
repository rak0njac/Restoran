package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.repositories.PorudzbinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PorudzbinaServiceImpl implements PorudzbinaService{

    @Autowired
    private PorudzbinaRepository porudzbinaRepository;
    @Override
    public List<Porudzbina> findByDatum(Date date) {
        return this.porudzbinaRepository.findByDatum(date);
    }

    @Override
    public Optional<Porudzbina> findByIDPorudzbina(Long id) {
        return this.porudzbinaRepository.findById(id);
    }

    @Override
    public void insert(Porudzbina porudzbina) {
        porudzbinaRepository.save(porudzbina);
    }

    @Override
    public void delete(Porudzbina porudzbina) {
       porudzbinaRepository.delete(porudzbina);
    }
}
