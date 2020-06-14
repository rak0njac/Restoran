package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
