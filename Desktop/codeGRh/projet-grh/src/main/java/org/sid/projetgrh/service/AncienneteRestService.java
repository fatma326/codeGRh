package org.sid.projetgrh.service;

import org.sid.projetgrh.Anciennete;
import org.sid.projetgrh.dao.AncienneteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AncienneteRestService {
    @Autowired
    AncienneteRepository AncienneteRepository;

    @GetMapping(value = "/AncienneteList")
    public List<Anciennete> AncienneteList(){
        return AncienneteRepository.findAll();

    }

    @GetMapping(value = "/AncienneteList/{id}")
    public Anciennete AncienneteList(@PathVariable(name = "id")long id){
        return  AncienneteRepository.findById(id).get();

    }

    @PutMapping(value = "/AncienneteList/{id}")
    public Anciennete update(@PathVariable(name = "id")long id,@RequestBody Anciennete a ){
        return AncienneteRepository.save(a);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/AncienneteList")
    public Anciennete save(@RequestBody Anciennete a){
        return AncienneteRepository.save(a);
    }

    @DeleteMapping (value = "/AncienneteList/{id}")
    public void delete(@PathVariable(name = "id")long id){

        AncienneteRepository.deleteById(id);

    }









}
