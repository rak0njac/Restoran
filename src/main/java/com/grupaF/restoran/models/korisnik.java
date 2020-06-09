package com.grupaF.restoran.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "korisniks")
public class korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDKorisnik;

    @Column(name = "email")
    @NotBlank(message= "Morate uneti Email")
    @Email(message = "Email mora biti validan")
    private String email;

    @Column(name = "adresa")
    @NotBlank(message= "Morate uneti adresu")
    private String adresa;

    @Column(name = "ime")
    @NotBlank(message= "Morate uneti ime")
    private String ime;

    @Column(name = "prezime")
    @NotBlank(message= "Morate uneti prezime")
    private String prezime;

    @Column(name = "telefon")
    @NotBlank(message= "Morate uneti telefon")
    private String telefon;

    @Column(name = "username")
    @NotBlank(message= "Morate uneti username")
    private String username;

    @Column(name = "password")
    @NotBlank(message= "Morate uneti password")
    @Size(min = 7, max = 50, message
            = "Password mora imate vise od 7 karaktera i manje od 50")
    private String password;

    @Column(name = "tip")
    private String tip;

    @OneToMany(mappedBy = "korisnik",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    private Set<Porudzbina> Porudzbinas;

    public Long getiDKorisnik() {
        return iDKorisnik;
    }

    public void setiDKorisnik(Long iDKorisnik) {
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
