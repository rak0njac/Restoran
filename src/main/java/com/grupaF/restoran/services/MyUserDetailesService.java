package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class MyUserDetailesService implements UserDetailsService {

    @Autowired
    KorisnikRepository korisnikRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Korisnik> korisnik = korisnikRepository.findByUsername(s);
        korisnik.orElseThrow(()->new UsernameNotFoundException("Korisnik nije nadjen u bazi!" + s));
        return korisnik.map(MyUserDetails::new).get();
    }

}
