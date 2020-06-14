package com.grupaF.restoran.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Porudzbina_proizvod_key implements Serializable {

    @Column(name = "iDPorudzbina")
    Long iDPorudzbina;

    @Column(name = "iDProizvod")
    Long iDProizvod;

    public Long getiDPorudzbina() {
        return iDPorudzbina;
    }

    public void setiDPorudzbina(Long iDPorudzbina) {
        this.iDPorudzbina = iDPorudzbina;
    }

    public Long getiDProizvod() {
        return iDProizvod;
    }

    public void setiDProizvod(Long iDProizvod) {
        this.iDProizvod = iDProizvod;
    }
}
