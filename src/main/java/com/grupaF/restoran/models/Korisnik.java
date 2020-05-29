package com.grupaF.restoran.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "korisniks")
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDKorisnik;

    @Column(name = "email")
   //@NotBlank(message= "Email cannot be blank")
    private String email;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "tip")
    private String tip;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "iDPorudzbina")
    private Set<Porudzbina> Porudzbinas;

    public int getiDKorisnik() {
        return iDKorisnik;
    }

    public void setiDKorisnik(int iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
