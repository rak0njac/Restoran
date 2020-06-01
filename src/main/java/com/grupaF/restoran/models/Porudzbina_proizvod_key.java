package com.grupaF.restoran.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Porudzbina_proizvod_key implements Serializable {

    @Column(name = "iDPorudzbina")
    Long iDPorudzbina;

    @Column(name = "iDProizvod")
    int iDProizvod;

    public Long getiDPorudzbina() {
        return iDPorudzbina;
    }

    public void setiDPorudzbina(Long iDPorudzbina) {
        this.iDPorudzbina = iDPorudzbina;
    }

    public int getiDProizvod() {
        return iDProizvod;
    }

    public void setiDProizvod(int iDProizvod) {
        this.iDProizvod = iDProizvod;
    }
}
