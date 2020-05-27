package models;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
@Entity
@Table(name = "porudzbinas")
public class Porudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int iDPorudzbina;

    @Column(name = "otkazano")
    private boolean otkazano;

    @Column(name = "datum")
    private Date datum;

    @Column(name = "vreme")
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
