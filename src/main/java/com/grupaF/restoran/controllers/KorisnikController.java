package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value = "/{iDKorisnik}")
    public String getKorisnik(@PathVariable Long iDKorisnik, Model model) {

        Optional<Korisnik> k = this.korisnikService.findBykorisnikId(iDKorisnik);
        if (k.isPresent()) {
            model.addAttribute("korisnik", k.get());
        }

        return "korisnik";

    }

    @GetMapping
    public String getAll(Model model) {

        List<Korisnik>korisnici = this.korisnikService.findAll();
        model.addAttribute("korisnici",korisnici);
        return "profil";
    }

}
