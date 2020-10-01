package org.sid.projetgrh.service;

import org.sid.projetgrh.Departement;
import org.sid.projetgrh.dao.derpartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartementRestService {
    @Autowired
    derpartementRepository derpartementRepository;

    @GetMapping(value = "/depList")
    public List<Departement> depList(){
        return derpartementRepository.findAll();

    }

    @GetMapping(value = "/depList/{id }")
    public Departement depList(@PathVariable(name = "id")long id){
        return  derpartementRepository.findById(id).get();

    }

    @PutMapping(value = "/depList/{id}")
    public Departement update(@PathVariable(name = "id")long id,@RequestBody Departement d ){
        return derpartementRepository.save(d);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/depList")
    public Departement save(@RequestBody Departement d){
        return derpartementRepository.save(d);
    }

    @DeleteMapping (value =  "/depList/{id}")
    public void delete(@PathVariable(name = "id")long id){

        derpartementRepository.deleteById(id);

    }










}
