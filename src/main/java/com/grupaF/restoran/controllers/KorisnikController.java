package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @GetMapping(value = "/getKorisnik/{id}")
    public String getKorisnik(@PathVariable Long id, Model model) {
          Optional<korisnik> k = this.korisnikService.findById(id);
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
        List<korisnik>korisnici = korisnikService.findAll();
        model.addAttribute("korisnici",korisnici);
        return "korisnici";
    }

//    @RequestMapping("/edit/{id}"){
////    public String updateUser(@PathVariable("iDKorisnik") long iDKorisnik, @Valid Korisnik korisnik,
////                             BindingResult result, Model model) {
////        if (result.hasErrors()) {
////            korisnik.setiDKorisnik(iDKorisnik);
////            return "profilKorisnik";
////        }
////
////        korisnikService.insert(korisnik);
////        model.addAttribute("korisnici", korisnikService.findAll());
////        return "index";
//
//    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        korisnik korisnik = korisnikService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + id));
        model.addAttribute("korisnik", korisnik);
        return "updateKorisnik";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, @Valid korisnik korisnik,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            korisnik.setiDKorisnik(id);
            return "updateKorisnik";
        }
        korisnikService.deleteById(id);
        //Ideja je da prvo odradimo deleteById odabranog korisnika, a zatim ubacimo novog korisnika sa identicnim
        //ID a novim podacima unetim u edit formi. Ako ne uradimo tako, hibernate se buni jer diramo ID korisnika koji
        //od kojeg zavisi tabela Porudzbina. Medjutim, ne radi kako treba, jer nakon sto uradimo save, umesto da mu dodeli
        //ID koji smo upisali u formi, on mu dodeljuje automatski ID uvecan za 1 od poslednjeg ID (kao sto bi trebalo kad
        //ne bi bio upisan nikakav ID). Takodje, hibernate ne dozvoljava edit ako u formi nisu upisani svi podaci koji su
        // u modelu stavljeni kao NotBlank ili neke druge validacione restrikcije. Ovo se delimicno moze resiti stavljanjem
        // hidden na te nepotrebne inpute u edit formi, ali je to katastrofa za security a i generalno. FIXME!
        korisnikService.save(korisnik);
        model.addAttribute("korisnici", korisnikService.findAll());
        return "korisnici";
    }


   @RequestMapping(value="/delete/{iDKorisnik}")
    public String delete(@PathVariable("iDKorisnik") long iDKorisnik, Model model) {
        korisnik korisnik = korisnikService.findById(iDKorisnik)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa unetim id:" + iDKorisnik));
        korisnikService.deleteById(korisnik.getiDKorisnik());
        model.addAttribute("korisnici", korisnikService.findAll());
        return "korisnici";
    }
}
