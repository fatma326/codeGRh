package org.sid.projetgrh.service;
import org.sid.projetgrh.Type_contrat;
import org.sid.projetgrh.dao.typeContrat_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Type_conRestService {

    @Autowired

    typeContrat_Repository typeContrat_Repository;

    @GetMapping(value = "/typeConList")
    public List<Type_contrat> type_contratList(){
        return typeContrat_Repository.findAll();

    }

    @GetMapping(value = "/typeConList/{id}")
    public Type_contrat  type_contratList(@PathVariable(name = "id")long id){
        return  typeContrat_Repository.findById(id).get();

    }

    @PutMapping(value = "/typeConList/{id}")
    public Type_contrat  update(@PathVariable(name = "id")long id,@RequestBody Type_contrat c){
        return typeContrat_Repository.save(c);

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/typeConList")
    public Type_contrat save(@RequestBody Type_contrat c){
        return typeContrat_Repository.save(c);
    }

    @DeleteMapping (value = "/typeConList/{id}")
    public void delete(@PathVariable(name = "id")long id){

        typeContrat_Repository.deleteById(id);

    }







}
