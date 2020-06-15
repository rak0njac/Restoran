package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Korisnik;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private String tip;
    public MyUserDetails(Korisnik korisnik){
        this.username = korisnik.getUsername();
        this.password = korisnik.getPassword();
        this.id = korisnik.getiDKorisnik();
        this.tip = korisnik.getTip();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if(tip.equals("korisnik")){
           return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
       }
       else{
           return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
       }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public Long getIdKorisnik() {return id; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
