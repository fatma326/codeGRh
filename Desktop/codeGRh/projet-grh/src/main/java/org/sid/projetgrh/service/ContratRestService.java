package org.sid.projetgrh.service;

import org.sid.projetgrh.Contrats;
import org.sid.projetgrh.dao.ContratsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContratRestService {
    @Autowired
    ContratsRepository ContratsRepository;

    @GetMapping(value = "/ContratList")
    public List<Contrats> ContratList(){
        return ContratsRepository.findAll();

    }

    @GetMapping(value = "/ContratList/{idContrats}")
    public Contrats ContratList(@PathVariable(name = "idContrats")long idContrats){
        return  ContratsRepository.findById(idContrats).get();

    }

    @PutMapping(value = "/ContratList/{idContrats}")
    public Contrats update(@PathVariable(name = "idContrats")long idContrats,@RequestBody Contrats c ){
        return ContratsRepository.save(c);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/ContratList")
    public Contrats save(@RequestBody Contrats c){
        return ContratsRepository.save(c);
    }

    @DeleteMapping (value =  "/ContratList/{idContrats}")
    public void delete(@PathVariable(name = "idContrats")long idContrats){

        ContratsRepository.deleteById(idContrats);

    }







}
