package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;



    @Override
    public List<Korisnik> finBykorisnikId(int iDKorisnik) {
        return this.korisnikRepository.finBykorisnikId(iDKorisnik);
    }

    @Override
    public List<Korisnik> findByUserNameAndPassword(String username, String password) {
        return this.korisnikRepository.findByUserNameAndPassword(username, password);
    }

    @Override
    public void delete(Korisnik korisnik) {
        korisnikRepository.delete(korisnik);

    }

    @Override
    public void insert(Korisnik korisnik) {
        korisnikRepository.insert(korisnik);

    }

    @Override
    public void edit(Korisnik korisnik) {
        korisnikRepository.edit(korisnik);

    }
}
