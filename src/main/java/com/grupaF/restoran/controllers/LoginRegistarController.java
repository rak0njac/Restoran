package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class LoginRegistarController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value="/login")
    public String login(@PathVariable String username, String password, Model model){
        Optional<Korisnik> k = this.korisnikService.findByUsernameAndPassword(username, password);
        if(k.isPresent()){
            model.addAttribute("korisnici", k.get());
            return "index";
        }
        else return "Error";
    }
   @GetMapping
   public String homePage(){
        return "loginSingin";
   }

    @PostMapping(value = "/registracija")
    String newKorisnik(@RequestBody Korisnik newKorisnik)
    {
        korisnikService.insert(newKorisnik);
        return "loginSingin";
    }
}
