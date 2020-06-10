package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.models.korisnik;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/proizvodi")
public class ProizvodController {
    @Autowired
    private ProizvodService proizvodService;

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        List<Proizvod> proizvodi = this.proizvodService.findAll();
        model.addAttribute("proizvodi",proizvodi);
        return "proizvodi";
    }

    @RequestMapping(value="/delete/{iDProizvod}")
    public String delete(@PathVariable("iDProizvod") long iDProizvod, Model model) {
       // Optional<Proizvod> proizvod = proizvodService.findById(iDProizvod);

        Proizvod proizvod = proizvodService.findById(iDProizvod)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji proizvod sa unetim id:" + iDProizvod));

        proizvodService.deleteById(proizvod.getiDProizvod());

        model.addAttribute("proizvodi", proizvodService.findAll());
        return "proizvodi";
    }

//    @GetMapping(value = "/editProizvod/{id}")
//    public String editProizvod(@PathVariable("id") Long id, Model model) {
//        Optional<Proizvod> p = this.proizvodService.findById(id);
//        if (p.isPresent()) {
//            model.addAttribute("proizvod", p.get());
//            return "updateProizvod";
//        }
//        else{
//            return "Error";
//        }
//    }

    @PostMapping("/editProizvod/{idProizvod}")
    public String updateProizvod(@PathVariable("idProizvod") long idProizvod, @Valid Proizvod proizvod,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            proizvod.setiDProizvod(idProizvod);
            return "proizvodi";
        }

        proizvodService.insert(proizvod);
        model.addAttribute("proizvodi", proizvodService.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Proizvod proizvod = proizvodService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ne postoji korisnik sa ID " + id));
        model.addAttribute("proizvod", proizvod);
        return "updateProizvod";
    }


    @PostMapping("/edit")
    public String edit(@RequestParam("iDProizvod") Long iDProizvod,  @RequestParam("opis") String opis, @RequestParam("cena") int cena,
                       @RequestParam("slika") String slika,   @RequestParam("naziv") String naziv, Model model)
    {
        proizvodService.editQuery(cena, opis, slika, naziv, iDProizvod);
        List<Proizvod> proizvodi = proizvodService.findAll();
        model.addAttribute("proizvodi", proizvodi);
        return "proizvodi";
    }
}
