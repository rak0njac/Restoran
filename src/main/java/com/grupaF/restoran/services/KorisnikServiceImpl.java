package com.grupaF.restoran.services;

import com.grupaF.restoran.models.korisnik;
import com.grupaF.restoran.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    //private Object Optional;

    @Override
    public Optional<korisnik> findById(Long iDKorisnik) {
        return this.korisnikRepository.findById(iDKorisnik);
    }

    @Override
    public Optional<korisnik> findByUsernameAndPassword(String username, String password) {
        return this.korisnikRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<korisnik> findAll() {
        return this.korisnikRepository.findAll();
    }

    @Override
    public void delete(korisnik korisnik) {
       korisnikRepository.delete(korisnik);
   }

//    @Override
//    public Korisnik insert(Korisnik korisnik) {
//        return korisnikRepository.save(korisnik);
//    }

    @Override
    public korisnik save(korisnik korisnik) { return korisnikRepository.save(korisnik);

    }

    @Override
    public void deleteById(Long iDKorisnik) {
         korisnikRepository.deleteById(iDKorisnik);
    }


}
