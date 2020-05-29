package com.grupaF.restoran.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Porudzbina_proizvod_key implements Serializable {

    @Column(name = "iDPorudzbina")
    int iDPorudzbina;

    @Column(name = "iDProizvod")
    int iDProizvod;

    public int getiDPorudzbina() {
        return iDPorudzbina;
    }

    public void setiDPorudzbina(int iDPorudzbina) {
        this.iDPorudzbina = iDPorudzbina;
    }

    public int getiDProizvod() {
        return iDProizvod;
    }

    public void setiDProizvod(int iDProizvod) {
        this.iDProizvod = iDProizvod;
    }
}
