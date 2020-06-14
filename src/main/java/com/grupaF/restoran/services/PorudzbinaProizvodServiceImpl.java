package com.grupaF.restoran.services;

import com.grupaF.restoran.models.Porudzbina;
import com.grupaF.restoran.models.Porudzbina_proizvod;
import com.grupaF.restoran.repositories.PorudzbinaProizvodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PorudzbinaProizvodServiceImpl implements PorudzbinaProizvodService{

    @Autowired
    private PorudzbinaProizvodRepository porudzbinaProizvodRepository;
   // @Override
   // public List<Porudzbina> findByDatum(Date date) {
   //     return this.porudzbinaRepository.findByDatum(date);
   // }
//
   // @Override
   // public Optional<Porudzbina> findByIDPorudzbina(Long id) {
   //     return this.porudzbinaRepository.findById(id);
   // }
//
    @Override
    public List<Porudzbina_proizvod> findAll(){return this.porudzbinaProizvodRepository.findAll();}

    //@Override
    //public void deleteById(Long iDPorudzbina) {
    //     this.porudzbinaRepository.deleteById(iDPorudzbina);
    //}
//
    @Override
    public Porudzbina_proizvod insert(Porudzbina_proizvod porudzbina_proizvod) {
        return porudzbinaProizvodRepository.save(porudzbina_proizvod);
    }

    //@Override
    //public void delete(Long iDPorudzbina) { porudzbinaRepository.deleteById(iDPorudzbina);
    //}
//
    //@Override
    //public Porudzbina edit(Porudzbina porudzbina){return porudzbinaRepository.save(porudzbina);}
//
}
