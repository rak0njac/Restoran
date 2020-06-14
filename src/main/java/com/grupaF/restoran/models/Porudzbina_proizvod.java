package com.grupaF.restoran.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "porudzbina_proizvods")
public class Porudzbina_proizvod {

    public Porudzbina_proizvod_key getId() {
        return id;
    }

    public void setId(Porudzbina_proizvod_key id) {
        this.id = id;
    }

    @EmbeddedId
    Porudzbina_proizvod_key id;

    @ManyToOne
    @MapsId("iDPorudzbina")
    @JoinColumn(name = "iDPorudzbina")
    Porudzbina porudzbina;

    @ManyToOne
    @MapsId("iDProizvod")
    @JoinColumn(name = "iDProizvod")
    Proizvod proizvod;


    public void setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Column(name = "kolicina")
    @Min(value= 1, message="Kolicina mora biti veca od 0")
    private int kolicina;

    @Column(name = "cena")
    private int cena;

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

//    public void setPorudzbina(Porudzbina porudzbina) {
//        this.porudzbina = porudzbina;
//    }

    public Proizvod getProizvod() {
        return proizvod;
    }

//    public void setProizvod(Proizvod proizvod) {
//        this.proizvod = proizvod;
//    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
