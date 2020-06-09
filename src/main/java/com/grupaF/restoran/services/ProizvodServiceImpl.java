package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.repositories.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProizvodServiceImpl implements ProizvodService{

    @Autowired
    private ProizvodRepository proizvodRepository;

    @Override
    public List<Proizvod> findByNaziv(String naziv) {
        return this.proizvodRepository.findByNaziv(naziv);
    }

    @Override
    public List<Proizvod> findAll() {
        return this.proizvodRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        proizvodRepository.deleteById(id);
    }

    @Override
    public void deleteById(Long iDProizvod) {
        proizvodRepository.deleteById(iDProizvod);
    }

    @Override
    public List<Proizvod> findByVrsta(String vrsta) {
        return this.proizvodRepository.findByVrsta(vrsta);
    }


    @Override
    public Proizvod insert(Proizvod proizvod) {
        return proizvodRepository.save(proizvod);
    }

    @Override
    public Optional<Proizvod> findById(Long id) {
        return this.proizvodRepository.findById(id);
    }

    @Override
    public Proizvod edit(Proizvod proizvod) {return proizvodRepository.save(proizvod);
    }




}
