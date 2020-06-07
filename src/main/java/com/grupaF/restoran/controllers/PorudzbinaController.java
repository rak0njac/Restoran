package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.services.KorisnikService;
import com.grupaF.restoran.services.PorudzbinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping ("/porudzbine")
public class PorudzbinaController {
    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping
    public String getAll(Model model) {
        //Model salje podatke za renderovanje
        List<Porudzbina> porudzbine = this.porudzbinaService.findAll();
        model.addAttribute("porudzbine",porudzbine);
        return "porudzbine";
    }


}
