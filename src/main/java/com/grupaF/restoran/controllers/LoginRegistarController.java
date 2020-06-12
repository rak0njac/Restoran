package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
public class LoginRegistarController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value="/licniKarton")
    public String profil(){return "licniKarton"; }

    @GetMapping(value="/kontakt")
    public String kontakt(){return "kontakt"; }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username, HttpSession session , @RequestParam String password, Model model){
        Optional<Korisnik> k = this.korisnikService.findByUsernameAndPassword(username, password);
        if(k.isPresent()){
            Korisnik m=new Korisnik();
            session.setAttribute("id", k.get().getiDKorisnik());
            session.setAttribute("prezime", k.get().getPrezime());
            session.setAttribute("ime", k.get().getIme());
            session.setAttribute("adresa", k.get().getAdresa());
            session.setAttribute("telefon", k.get().getTelefon());
            session.setAttribute("email", k.get().getEmail());
            session.setAttribute("username", k.get().getUsername());
//            session.setAttribute("korisnik", k.get());
            return "index";
        }
        else return "error1";

    }

    @GetMapping(value="/registracija")
    public String reg(){return "loginSingin"; }

    @GetMapping
    public String homePage(){
        return "index";
    }


    @PostMapping(value = "/dodaj")
    public String dodaj(@RequestParam String username, @RequestParam String password, @RequestParam String ime, @RequestParam String prezime,
                        @RequestParam String telefon, @RequestParam String tip, @RequestParam String email,
                        @RequestParam String adresa, Model model)
    {
        Korisnik k = new Korisnik();
        k.setUsername(username);
        k.setPassword(password);
        k.setTelefon(telefon);
        k.setTip(tip);
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setEmail(email);
        k.setAdresa(adresa);


        korisnikService.save(k);

        return "loginSingin";
    }

}