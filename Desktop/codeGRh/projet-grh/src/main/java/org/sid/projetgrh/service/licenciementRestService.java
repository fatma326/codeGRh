package org.sid.projetgrh.service;


import org.sid.projetgrh.dao.licenciementRepository;
import org.sid.projetgrh.licenciement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class licenciementRestService {
    @Autowired
    licenciementRepository licenciementRepository;


    @GetMapping(value = "/licenciementList")
    public List<licenciement> licenciementList(){
        return licenciementRepository.findAll();

    }

    @GetMapping(value = "/licenciementList/{id}")
    public licenciement licenciementList(@PathVariable(name = "id")long id){
        return  licenciementRepository.findById(id).get();

    }

    @PutMapping(value = "/licenciementList/{id}")
    public licenciement update(@PathVariable(name = "id")long id,@RequestBody licenciement l ){
        return licenciementRepository.save(l);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/licenciementList")
    public licenciement save(@RequestBody licenciement l){
        return licenciementRepository.save(l);
    }

    @DeleteMapping (value =  "/licenciementList/{id}")
    public void delete(@PathVariable(name = "id")long id){

        licenciementRepository.deleteById(id);

    }
}
