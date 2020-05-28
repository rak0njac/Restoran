package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "proizvods")
public class Proizvod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDProizvod;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "vrsta")
    private String vrsta;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena")
    private int cena;

    @Column(name = "slika")
    private String slika;

    @OneToMany(mappedBy = "proizvod")
    Set<Porudzbina_proizvod> porudzbina_proizvods;

    public int getiDProizvod() {
        return iDProizvod;
    }

    public void setiDProizvod(int iDProizvod) {
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
