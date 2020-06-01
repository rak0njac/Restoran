package com.grupaF.restoran.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "proizvods")
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDProizvod;

    @Column(name = "naziv")
    @Size(min = 1, max = 200, message
            = "Naziv mora imati izmedju 10 i 200 karaktera")
    private String naziv;

    @Column(name = "vrsta")
    @Size(min = 1, max = 200, message
            = "Vrsta mora imati izmedju 1 i 200 karaktera")
    private String vrsta;

    @Column(name = "opis")
    @Size(min = 10, max = 200, message
            = "Opis mora imati izmedju 10 i 200 karaktera")
    private String opis;

    @Column(name = "cena")
    @Min(value= 1, message="Cena mora biti veca od 0")
    private int cena;

    @Column(name = "slika")
    private String slika;

    @OneToMany(mappedBy = "proizvod")
    Set<Porudzbina_proizvod> porudzbina_proizvods;

    public Long getiDProizvod() {
        return iDProizvod;
    }

    public void setiDProizvod(Long iDProizvod) {
        this.iDProizvod = iDProizvod;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
