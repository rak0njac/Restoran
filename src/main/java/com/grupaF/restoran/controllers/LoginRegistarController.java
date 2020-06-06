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


    //@GetMapping (value="/login/{username}/{password}") - ne koristi se nikada kada trebaju da se uzimaju neki vazni podaci
    //Razlika izmedju PathVarivable  to mi je - /login/{username} - i vide mu se parametri u brauzeru - putanje
    //RequestParam - bice u brauzeru login?username=mikimiki&password=mikica13 ide sa GetMapping

    //RequestBody - json format i u njemu su samo sakriveni parametri
    //@PostMapping(value="/login")
    //@ResponseBody
    /*public String login(@RequestBody Korisnik korisnik, Model model){
        System.out.println(korisnik);
        Optional<Korisnik> k = this.korisnikService.findByUsernameAndPassword(korisnik.getUsername(), korisnik.getPassword());
        if(k.isPresent()){
            model.addAttribute("korisnici", k.get());

            return "index";
        }
        else {
            model.addAttribute("korisnici", korisnik);
            return "profil";
        }

}*/
    //@GetMapping(value="/login/{username}/{password}")
    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model){
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
