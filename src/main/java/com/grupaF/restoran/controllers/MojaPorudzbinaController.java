package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.*;
import com.grupaF.restoran.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;

@Controller
@RequestMapping ("/mojePorudzbine")
public class MojaPorudzbinaController {
    @Autowired
    private PorudzbinaService porudzbinaService;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private ProizvodService proizvodService;

    @Autowired
    private PorudzbinaProizvodService porudzbinaProizvodService;

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = ((MyUserDetails)principal).getIdKorisnik();
        List<Porudzbina> porudzbine = this.porudzbinaService.findAll();
        List<Porudzbina> list = null;
        for(Porudzbina p : porudzbine)
        {
            if (p.getKorisnik().getiDKorisnik() == id)
                list.add(p);
        }
        model.addAttribute("porudzbine",list);
        return "porudzbine";
    }

    @PostMapping(value = "/napravi")
    @ResponseBody
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

        return p.getiDPorudzbina().toString();
    }

    @PostMapping(value = "/napraviStavku")
    public String napraviStavku(@RequestParam Long iDPorudzbina,
                                    @RequestParam Long iDProizvod,
                                    @RequestParam int cena,
                                    @RequestParam int kolicina,
                                    Model model)
    {
        Optional<Porudzbina> p = porudzbinaService.findByIDPorudzbina(iDPorudzbina);
        Optional<Proizvod> pr = proizvodService.findById(iDProizvod);
        Porudzbina_proizvod pp = new Porudzbina_proizvod();
        Porudzbina_proizvod_key ppk = new Porudzbina_proizvod_key();
        ppk.setiDPorudzbina(iDPorudzbina);
        ppk.setiDProizvod(iDProizvod);
        pp.setId(ppk);
        pp.setCena(cena);
        pp.setKolicina(kolicina);
        pp.setPorudzbina(p.get());
        pp.setProizvod(pr.get());
        porudzbinaProizvodService.insert(pp);
        //porudzbinaService.insert(p);
        List<Porudzbina> porudzbine = porudzbinaService.findAll();
        model.addAttribute("porudzbine", porudzbine);
        return "porudzbine";
    }

    @GetMapping("/success/{iDPorudzbina}")
    public String successPorudzbina(@PathVariable("iDPorudzbina") Long iDPorudzbina, Model model)
    {
        Porudzbina porudzbina = porudzbinaService.findByIDPorudzbina(iDPorudzbina)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji porudzbina sa unetim id:" + iDPorudzbina));

        model.addAttribute("porudzbina", porudzbina);
        return "uspesnoKreiranaPorudzbina";
    }

    @GetMapping("/show/{iDPorudzbina}")
    public String showPorudzbina(@PathVariable("iDPorudzbina") Long iDPorudzbina, Model model)
    {
        Porudzbina porudzbina = porudzbinaService.findByIDPorudzbina(iDPorudzbina)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji porudzbina sa unetim id:" + iDPorudzbina));

        Set<Porudzbina_proizvod> ppset = porudzbina.getPorudzbina_proizvods();

        model.addAttribute("porudzbina_proizvods", ppset);
        return "prikazPorudzbine";
    }


    @RequestMapping(value="/delete/{iDPorudzbina}")
    public String delete(@PathVariable("iDPorudzbina") long iDPorudzbina, Model model) {

        Porudzbina porudzbina = porudzbinaService.findByIDPorudzbina(iDPorudzbina)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji porudzbina sa unetim id:" + iDPorudzbina));

        porudzbinaService.deleteById(porudzbina.getiDPorudzbina());

        model.addAttribute("porudzbine", porudzbinaService.findAll());
        return "porudzbine";
    }

}
