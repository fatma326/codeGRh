package org.sid.projetgrh.service;

import org.sid.projetgrh.Type_departement;
import org.sid.projetgrh.dao.TypeDepartement_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Type_depRestService {

    @Autowired
    TypeDepartement_Repository  TypeDepartement_Repository;

    @GetMapping(value = "/typeDepList")
    public List<Type_departement>type_departementList(){
        return TypeDepartement_Repository.findAll();

    }

    @GetMapping(value = "/typeDepList/{idType}")
    public Type_departement  type_departementList(@PathVariable(name = "idType")long idType){
        return TypeDepartement_Repository.findById(idType).get();

    }


    @PutMapping(value = "/typeDepList/{idType}")
    public Type_departement  update(@PathVariable(name = "idType")long idType,@RequestBody Type_departement t){
        return TypeDepartement_Repository.save(t);

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/typeDepList")
    public Type_departement save(@RequestBody Type_departement t){
        return TypeDepartement_Repository.save(t);
    }

    @DeleteMapping (value = "/typeDepList/{idType}")
    public void delete(@PathVariable(name = "idType")long idType){

        TypeDepartement_Repository.deleteById(idType);

    }

}
