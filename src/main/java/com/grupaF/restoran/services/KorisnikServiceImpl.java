package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    //private Object Optional;

    @Override
    public Optional<Korisnik> findById(Long iDKorisnik) {
        return this.korisnikRepository.findById(iDKorisnik);
    }

    @Override
    public Optional<Korisnik> findByUsernameAndPassword(String username, String password) {
        return this.korisnikRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Korisnik> findAll() {
        return this.korisnikRepository.findAll();
    }

    @Override
    public void delete(Korisnik korisnik) {
       korisnikRepository.delete(korisnik);
   }

//    @Override
//    public Korisnik insert(Korisnik korisnik) {
//        return korisnikRepository.save(korisnik);
//    }

    @Override
    public Korisnik save(Korisnik korisnik) { return korisnikRepository.save(korisnik);

    }

    @Override
    public void deleteById(Long iDKorisnik) {
         korisnikRepository.deleteById(iDKorisnik);
    }
    @Transactional
    @Override
    public int editQuery(String adresa, String telefon, String email, String prezime, Long iDKorisnik) {
        return korisnikRepository.editQuery(adresa, telefon, email, prezime, iDKorisnik);
    }


}
