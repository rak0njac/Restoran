package models;

import java.sql.Time;
import java.util.Date;

public class Porudzbina {
    private int iDPorudzbina;
    private boolean otkazano;
    private Date datum;
    private Time vreme;
    private int iDKorisnik;

    public int getiDPorudzbina() {
        return iDPorudzbina;
    }

    public void setiDPorudzbina(int iDPorudzbina) {
        this.iDPorudzbina = iDPorudzbina;
    }

    public boolean isOtkazano() {
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

    public int getiDKorisnik() {
        return iDKorisnik;
    }

    public void setiDKorisnik(int iDKorisnik) {
        this.iDKorisnik = iDKorisnik;
    }
}
