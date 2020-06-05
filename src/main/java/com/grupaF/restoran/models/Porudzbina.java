package com.grupaF.restoran.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
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
    private Time vreme;

    @ManyToOne
    private Korisnik korisnik;

    @OneToMany(mappedBy = "porudzbina")
    Set<Porudzbina_proizvod> porudzbina_proizvods;

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

    public Time getVreme() {
        return vreme;
    }

    public void setVreme(Time vreme) {
        this.vreme = vreme;
    }


}
