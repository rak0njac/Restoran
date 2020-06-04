package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Korisnik;
import com.grupaF.restoran.services.KorisnikService;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("korisnici-rest")
public class RestKorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value = "/korisnici1/{iDKorisnik}")
    public ResponseEntity<Korisnik> getKorisnik(@PathVariable("iDKorisnik") Long iDKorisnik) {

        Optional<Korisnik> k = this.korisnikService.findBykorisnikId(iDKorisnik);
        return k.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/korisnici1")
    public ResponseEntity<List<Korisnik>> getAll() {
        return new ResponseEntity<>(this.korisnikService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/korisnici1")
    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik){
        return new ResponseEntity<>(this.korisnikService.insert(korisnik), HttpStatus.CREATED);
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
    ResponseEntity<Korisnik> update(@RequestBody Korisnik korisnik, @PathVariable Long iDKorisnik){
        Optional<Korisnik> postojeciKorisnik = this.korisnikService.findBykorisnikId(iDKorisnik);

        if(postojeciKorisnik.isPresent()){
            Korisnik noviKorisnik = postojeciKorisnik.get();
            noviKorisnik.setAdresa(korisnik.getAdresa());
            noviKorisnik.setEmail(korisnik.getEmail());
            noviKorisnik.setPrezime(korisnik.getPrezime());
            noviKorisnik.setPassword(korisnik.getPassword());
            noviKorisnik.setTelefon(korisnik.getTelefon());

            return new ResponseEntity<>(this.korisnikService.edit(noviKorisnik), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
