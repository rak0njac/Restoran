package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.KorisnikService;
import com.grupaF.restoran.services.PorudzbinaService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/porudzbine")
public class PorudzbinaController {
    @Autowired
    private PorudzbinaService porudzbinaService;

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        List<Porudzbina> porudzbine = this.porudzbinaService.findAll();
        model.addAttribute("porudzbine",porudzbine);
        return "porudzbine";
    }

    @PostMapping(value = "/napravi")
        public String napraviPorudzbinu(@RequestParam Date datum,
                                        @RequestParam String vreme,
                @RequestParam Long korisnik_idkorisnik,
                                        Model model)
    {
        //@RequestParam("datum") Date datum,
        Optional<Korisnik> korisnik = korisnikService.findById(korisnik_idkorisnik);
        Porudzbina p = new Porudzbina();
        if(korisnik.isPresent()) {
            p.setKorisnik(korisnik.get());
            p.setOtkazano(false);
            p.setDatum(datum);
            p.setVreme(LocalTime.parse(vreme));
        }
        porudzbinaService.insert(p);
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        model.addAttribute("porudzbine", porudzbine);
        return "porudzbine";
    }

    @RequestMapping(value="/delete/{iDPorudzbina}")
    public String delete(@PathVariable("iDPorudzbina") long iDPorudzbina, Model model) {

        Porudzbina porudzbina = porudzbinaService.findByIDPorudzbina(iDPorudzbina)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji proizvod sa unetim id:" + iDPorudzbina));

        porudzbinaService.deleteById(porudzbina.getiDPorudzbina());

        model.addAttribute("porudzbine", porudzbinaService.findAll());
        return "porudzbine";
    }

}
