package org.sid.projetgrh.service;
import org.sid.projetgrh.Conges;
import org.sid.projetgrh.dao.CongesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CongesRestService {

    @Autowired
    CongesRepository CongesRepository;


    @GetMapping(value = "/CongesList")
    public List<Conges> CongesList(){
        return CongesRepository.findAll();

    }

    @GetMapping(value = "/CongesList/{idConges}")
    public Conges CongesList(@PathVariable(name = "idConges")long idConges){
        return  CongesRepository.findById(idConges).get();

    }

    @PutMapping(value = "/CongesList/{idConges}")
    public Conges update(@PathVariable(name = "idConges")long idConges,@RequestBody Conges g ){
        return CongesRepository.save(g);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/CongesList")
    public Conges save(@RequestBody Conges g){
        return CongesRepository.save(g);
    }

    @DeleteMapping (value =  "/CongesList/{idConges}")
    public void delete(@PathVariable(name = "idConges")long idConges){

        CongesRepository.deleteById(idConges);

    }








}
