package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.models.korisnik;
import com.grupaF.restoran.services.KorisnikService;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dostava")
public class DostavaController {

    @Autowired
    private ProizvodService proizvodService;


    @GetMapping()
    public String getDostavaPage(Model model) {
        List<Proizvod> proizvodi = proizvodService.findAll();
        model.addAttribute("proizvodi", proizvodi);

        return "dostava";
    }

//    @GetMapping
//    public String getAll(Model model) {
//        //Model salje podatke za renderovanje
//        List<korisnik>korisnici = korisnikService.findAll();
//        model.addAttribute("korisnici",korisnici);
//        return "korisnici";
//    }
//
////    @RequestMapping("/edit/{id}"){
//////    public String updateUser(@PathVariable("iDKorisnik") long iDKorisnik, @Valid Korisnik korisnik,
//////                             BindingResult result, Model model) {
//////        if (result.hasErrors()) {
//////            korisnik.setiDKorisnik(iDKorisnik);
//////            return "profilKorisnik";
//////        }
//////
//////        korisnikService.insert(korisnik);
//////        model.addAttribute("korisnici", korisnikService.findAll());
//////        return "index";
////
////    }
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        korisnik korisnik = korisnikService.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + id));
//        model.addAttribute("korisnik", korisnik);
//        return "updateKorisnik";
//    }
//
//    @PostMapping("/edit")
//    public String edit(@RequestParam("iDKorisnik") Long iDKorisnik,  @RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon, @RequestParam("email") String email, @RequestParam("prezime") String prezime, Model model)
//                              {
//        korisnikService.editQuery(adresa, telefon, email, prezime, iDKorisnik);
//                                  List<korisnik>korisnici = korisnikService.findAll();
//                                  model.addAttribute("korisnici",korisnici);
//        return "korisnici";
//    }
//
//
//   @RequestMapping(value="/delete/{iDKorisnik}")
//    public String delete(@PathVariable("iDKorisnik") long iDKorisnik, Model model) {
//        korisnik korisnik = korisnikService.findById(iDKorisnik)
//                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa unetim id:" + iDKorisnik));
//        korisnikService.deleteById(korisnik.getiDKorisnik());
//        model.addAttribute("korisnici", korisnikService.findAll());
//        return "korisnici";
//    }

}