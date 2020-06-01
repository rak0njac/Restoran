package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;



    @Override
    public Optional<Korisnik> findBykorisnikId(Long iDKorisnik) {
        return this.korisnikRepository.findById(iDKorisnik);
    }

    @Override
    public Optional<Korisnik> findByUsernameAndPassword(String username, String password) {
        return this.korisnikRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void delete(Korisnik korisnik) {
        korisnikRepository.delete(korisnik);
    }

    @Override
    public void insert(Korisnik korisnik) {
        korisnikRepository.save(korisnik);

    }

    @Override
    public void edit(Korisnik korisnik) {
      //korisnikRepository.

    }
}