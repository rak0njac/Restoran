package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "porudzbina_proizvods")
public class Porudzbina_proizvod {
    private int iDPorudzbina;
    private int iDProizvod;

    @Column(name = "kolicina")
    private int kolicina;

    @Column(name = "cena")
    private int cena;


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
