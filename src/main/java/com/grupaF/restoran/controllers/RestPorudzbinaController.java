package com.grupaF.restoran.controllers;

import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.models.Proizvod;
import com.grupaF.restoran.services.PorudzbinaService;
import com.grupaF.restoran.services.ProizvodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("porudzbine-rest")
public class RestPorudzbinaController {
    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping(value = "/porudzbine1/{iDPorudzbina}")
    public ResponseEntity<Optional<Porudzbina>> getPorudzbinaId(@PathVariable("iDPorudzbina") Long id) {
        return new ResponseEntity<>(this.porudzbinaService.findByIDPorudzbina(id), HttpStatus.OK);
    }

//    @GetMapping(value = "/porudzbine1/vrsta/{vrsta}")
//    public ResponseEntity<List<Porudzbina>> getProizvodVrsta(@PathVariable("vrsta") String vrsta) {
//        return new ResponseEntity<>(this.porudzbinaService.findByVrsta(vrsta), HttpStatus.OK);
//    }

    @GetMapping(value = "/porudzbine1")
    public ResponseEntity<List<Porudzbina>> getAll() {
     return new ResponseEntity<>(this.porudzbinaService.findAll(), HttpStatus.OK);
   }

 @PostMapping(value="/porudzbine1")
    public ResponseEntity<Porudzbina> save(@RequestBody Porudzbina porudzbina){
        return new ResponseEntity<>(this.porudzbinaService.insert(porudzbina), HttpStatus.CREATED);
   }

   @DeleteMapping(value = "/porudzbine1/{iDPorudzbina}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("iDPorudzbina") Long iDPorudzbina){
            this.porudzbinaService.delete(iDPorudzbina);
    }

   @PutMapping(value = "/porudzbine1/{iDPorudzbina}")
   ResponseEntity<Porudzbina> update(@RequestBody Porudzbina porudzbina, @PathVariable Long iDPorudzbina){
       Optional<Porudzbina> postojecaPorudzbina = this.porudzbinaService.findByIDPorudzbina(iDPorudzbina);

        if(postojecaPorudzbina.isPresent()){
            Porudzbina novaPorudzbina = postojecaPorudzbina.get();
            novaPorudzbina.setOtkazano(porudzbina.getOtkazano());

            return new ResponseEntity<>(this.porudzbinaService.edit(novaPorudzbina), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
