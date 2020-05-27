package models;

public class Proizvod {
    private int iDProizvod;
    private String naziv;
    private String vrsta;
    private String opis;
    private int cena;
    private String slika;

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
