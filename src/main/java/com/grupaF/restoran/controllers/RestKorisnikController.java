package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("korisnici-rest")
public class RestKorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value = "/korisnici1/{iDKorisnik}")
    public ResponseEntity<korisnik> getKorisnik(@PathVariable("iDKorisnik") Long iDKorisnik) {

        Optional<korisnik> k = this.korisnikService.findById(iDKorisnik);
        return k.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/korisnici1")
    public ResponseEntity<List<korisnik>> getAll() {
        return new ResponseEntity<>(this.korisnikService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/korisnici1")
    public ResponseEntity<korisnik> save(@RequestBody korisnik korisnik){
        return new ResponseEntity<>(this.korisnikService.save(korisnik), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/korisnici1/{iDKorisnik}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("iDKorisnik") Long iDKorisnik){
            this.korisnikService.deleteById(iDKorisnik);
    }

//    @PutMapping(value = "/korisnici1/{iDKorisnik}")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable( "iDKorisnik" ) Long iDKorisnik, @RequestBody Korisnik korisnik) {
//        Preconditions.checkNotNull(korisnik);
//        RestPreconditions.checkNotNull(this.korisnikService.findBykorisnikId(korisnik.getiDKorisnik() );
//        service.update(resource);
//    }

    @PutMapping(value = "/korisnici1/{iDKorisnik}")
    ResponseEntity<korisnik> update(@RequestBody korisnik korisnik, @PathVariable Long iDKorisnik){
        Optional<com.grupaF.restoran.models.korisnik> postojeciKorisnik = this.korisnikService.findById(iDKorisnik);

        if(postojeciKorisnik.isPresent()){
            com.grupaF.restoran.models.korisnik noviKorisnik = postojeciKorisnik.get();
            noviKorisnik.setAdresa(korisnik.getAdresa());
            noviKorisnik.setEmail(korisnik.getEmail());
            noviKorisnik.setPrezime(korisnik.getPrezime());
            noviKorisnik.setPassword(korisnik.getPassword());
            noviKorisnik.setTelefon(korisnik.getTelefon());

            return new ResponseEntity<>(this.korisnikService.save(noviKorisnik), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
