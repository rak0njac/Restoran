package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;



    @GetMapping("/getKorisnik")
    public String pidUserSubmit(@RequestParam("myid") Long myid, Model model) {
        //log.debug("*** MY ID: {}", myid);
        Optional<Korisnik> k = this.korisnikService.findById(myid);
        model.addAttribute("korisnik", k.get());

        return "profilKorisnik";
    }

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        List<Korisnik>korisnici = korisnikService.findAll();
        model.addAttribute("korisnici",korisnici);
        return "korisnici";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Korisnik korisnik = korisnikService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + id));
        model.addAttribute("korisnik", korisnik);
        return "updateKorisnik";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam("iDKorisnik") Long iDKorisnik,
                       @RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon,
                       @RequestParam("email") String email, @RequestParam("prezime") String prezime, Model model)
                              {
        korisnikService.editQuery(adresa, telefon, email, prezime, iDKorisnik);
                                  List<Korisnik>korisnici = korisnikService.findAll();
                                  model.addAttribute("korisnici",korisnici);
        return "redirect:/korisnici";
    }

    @GetMapping("/editProfil/{id}")
    public String editProfil(@PathVariable("id") Long id, Model model) {
        Korisnik korisnik = korisnikService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + id));
        model.addAttribute("korisnik", korisnik);
        return "UpdateKorisnikLicniKarton";
    }

    @GetMapping("/getIdKorisnik")
    @ResponseBody
    public String GetIdKor(HttpSession session)
    {
        return session.getAttribute("id").toString();
        //return "1";
    }

    @PostMapping("/editProfil")
    public String editProfil(@RequestParam("iDKorisnik") Long iDKorisnik,  @RequestParam("adresa") String adresa, @RequestParam("telefon") String telefon,
                             @RequestParam("email") String email, @RequestParam("prezime") String prezime, Model model, HttpSession session)
    {
        korisnikService.editQuery(adresa, telefon, email, prezime, iDKorisnik);

        Korisnik k = korisnikService.findById(iDKorisnik).orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + iDKorisnik));

        session.setAttribute("id", k.getiDKorisnik());
        session.setAttribute("prezime", k.getPrezime());
        session.setAttribute("ime", k.getIme());
        session.setAttribute("adresa", k.getAdresa());
        session.setAttribute("telefon", k.getTelefon());
        session.setAttribute("email", k.getEmail());
        session.setAttribute("username", k.getUsername());

        model.addAttribute("korisnik",k);

        return "redirect:/licniKarton";
    }



    @RequestMapping(value="/delete/{iDKorisnik}")
    public String delete(@PathVariable("iDKorisnik") long iDKorisnik, Model model) {
        Korisnik korisnik = korisnikService.findById(iDKorisnik)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa unetim id:" + iDKorisnik));
        korisnikService.deleteById(korisnik.getiDKorisnik());
        model.addAttribute("korisnici", korisnikService.findAll());
        return "korisnici";
    }

}
