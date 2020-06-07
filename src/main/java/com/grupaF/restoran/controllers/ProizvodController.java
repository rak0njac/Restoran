package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.PorudzbinaService;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
