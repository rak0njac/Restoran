package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Proizvod;
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

    @GetMapping(value = "/proizvodi1")
    public ResponseEntity<List<Proizvod>> getAll() {
     return new ResponseEntity<>(this.proizvodService.findAll(), HttpStatus.OK);
   }

 @PostMapping(value="/proizvodi1")
    public ResponseEntity<Proizvod> save(@RequestBody Proizvod proizvod){
        return new ResponseEntity<>(this.proizvodService.insert(proizvod), HttpStatus.CREATED);
   }

   @DeleteMapping(value = "/proizvodi1/{iDProizvod}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("iDProizvod") Long iDProizvod){
            this.proizvodService.delete(iDProizvod);
    }

   @PutMapping(value = "/proizvodi1/{iDProizvod}")
   ResponseEntity<Proizvod> update(@RequestBody Proizvod proizvod, @PathVariable Long iDProizvod){
       Optional<Proizvod> postojeciProizvod = this.proizvodService.findById(iDProizvod);

        if(postojeciProizvod.isPresent()){
            Proizvod noviProizvod = postojeciProizvod.get();
            noviProizvod.setCena(proizvod.getCena());
            noviProizvod.setOpis(proizvod.getOpis());
            noviProizvod.setSlika(proizvod.getSlika());

            return new ResponseEntity<>(this.proizvodService.edit(noviProizvod), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
