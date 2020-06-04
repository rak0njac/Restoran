package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.KorisnikService;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("proizvodi-rest")
public class RestProizvodController {
    @Autowired
    private ProizvodService proizvodService;

    @GetMapping(value = "/proizvodi1/naziv/{naziv}")
    public ResponseEntity<List<Proizvod>> getProizvodNaziv(@PathVariable("naziv") String naziv) {
        return new ResponseEntity<>(this.proizvodService.findByNaziv(naziv), HttpStatus.OK);
    }

    @GetMapping(value = "/proizvodi1/vrsta/{vrsta}")
    public ResponseEntity<List<Proizvod>> getProizvodVrsta(@PathVariable("vrsta") String vrsta) {
        return new ResponseEntity<>(this.proizvodService.findByVrsta(vrsta), HttpStatus.OK);
    }

//    @GetMapping(value = "/proizvodi1")
//    public ResponseEntity<List<Korisnik>> getAll() {
//        return new ResponseEntity<>(this.korisnikService.findAll(), HttpStatus.OK);
//    }
//
//    @PostMapping(value="/proizvodi1")
//    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik){
//        return new ResponseEntity<>(this.korisnikService.insert(korisnik), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping(value = "/proizvodi1/{iDProizvod}")
//    @ResponseStatus(HttpStatus.OK)
//    public void delete(@PathVariable("iDProizvod") Long iDProizvod){
//            this.korisnikService.deleteById(iDProizvod);
//    }

//    @PutMapping(value = "/korisnici1/{iDKorisnik}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable( "iDKorisnik" ) Long iDKorisnik, @RequestBody Korisnik korisnik) {
//        Preconditions.checkNotNull(korisnik);
//        RestPreconditions.checkNotNull(this.korisnikService.findBykorisnikId(korisnik.getiDKorisnik() );
//        service.update(resource);
//    }

//    @PutMapping(value = "/proizvodi1/{iDProizvod}")
//    ResponseEntity<Korisnik> update(@RequestBody Korisnik korisnik, @PathVariable Long iDProizvod){
//        Optional<Korisnik> postojeciKorisnik = this.korisnikService.findBykorisnikId(iDProizvod);
//
//        if(postojeciKorisnik.isPresent()){
//            Korisnik noviKorisnik = postojeciKorisnik.get();
//            noviKorisnik.setAdresa(korisnik.getAdresa());
//            noviKorisnik.setEmail(korisnik.getEmail());
//            noviKorisnik.setPrezime(korisnik.getPrezime());
//            noviKorisnik.setPassword(korisnik.getPassword());
//            noviKorisnik.setTelefon(korisnik.getTelefon());
//
//            return new ResponseEntity<>(this.korisnikService.edit(noviKorisnik), HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


}
