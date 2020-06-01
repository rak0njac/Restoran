package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.repositories.ProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProizvodServiceImpl implements ProizvodService{

    @Autowired
    private ProizvodRepository proizvodRepository;

    @Override
    public List<Proizvod> findByNaziv(String naziv) {
        return this.proizvodRepository.findByNaziv(naziv);
    }

    @Override
    public List<Proizvod> findByVrsta(String vrsta) {
        return this.proizvodRepository.findByVrsta(vrsta);
    }
    @Override
    public void delete(Proizvod proizvod) {
        proizvodRepository.delete(proizvod);
    }

    @Override
    public void insert(Proizvod proizvod) {
        proizvodRepository.save(proizvod);
    }

    @Override
    public void edit(Proizvod proizvod) {
        proizvodRepository.save(proizvod);
    }
}
