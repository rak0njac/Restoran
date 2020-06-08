package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    //@GetMapping(value = "/{iDKorisnik}")
    @GetMapping(value = "/getKorisnik/{id}")
    public String getKorisnik(@PathVariable Long id, Model model) {
          Optional<Korisnik> k = this.korisnikService.findBykorisnikId(id);
        if (k.isPresent()) {
            model.addAttribute("korisnik", k.get());
            return "profilKorisnik";
        }
        else{
            return "Error";
        }
    }

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        List<Korisnik>korisnici = this.korisnikService.findAll();
        model.addAttribute("korisnici",korisnici);
        return "profil";
    }

    @PostMapping("/editKorisnik/{id}")
    public String updateUser(@PathVariable("iDKorisnik") long iDKorisnik, @Valid Korisnik korisnik,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            korisnik.setiDKorisnik(iDKorisnik);
            return "profilKorisnik";
        }

        korisnikService.insert(korisnik);
        model.addAttribute("korisnici", korisnikService.findAll());
        return "index";
    }


   @RequestMapping(value="/delete/{iDKorisnik}")
    public String delete(@PathVariable("iDKorisnik") long iDKorisnik, Model model) {
        Korisnik korisnik = korisnikService.findBykorisnikId(iDKorisnik)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa unetim id:" + iDKorisnik));
        korisnikService.deleteById(korisnik.getiDKorisnik());
        model.addAttribute("korisnici", korisnikService.findAll());
        return "profil";
    }





}
