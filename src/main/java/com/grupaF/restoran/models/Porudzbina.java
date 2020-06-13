package com.grupaF.restoran.models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "porudzbinas")
public class Porudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDPorudzbina;

    @Column(name = "otkazano")
    private boolean otkazano;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "vreme")
    private LocalTime vreme;

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @ManyToOne
    private Korisnik korisnik;

    @OneToMany(mappedBy = "porudzbina")
    Set<Porudzbina_proizvod> porudzbina_proizvods;

    public Set<Porudzbina_proizvod> getPorudzbina_proizvods() {
        return porudzbina_proizvods;
    }

    public void setPorudzbina_proizvods(Set<Porudzbina_proizvod> porudzbina_proizvods) {
        this.porudzbina_proizvods = porudzbina_proizvods;
    }

    public Long getiDPorudzbina() {
        return iDPorudzbina;
    }

    public void setiDPorudzbina(Long iDPorudzbina) {
        this.iDPorudzbina = iDPorudzbina;
    }

    public boolean getOtkazano() {
        return otkazano;
    }

    public void setOtkazano(boolean otkazano) {
        this.otkazano = otkazano;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public LocalTime getVreme() {
        return vreme;
    }

    public void setVreme(LocalTime vreme) {
        this.vreme = vreme;
    }


}
