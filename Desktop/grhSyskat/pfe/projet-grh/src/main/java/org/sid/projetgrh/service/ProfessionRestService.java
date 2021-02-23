package org.sid.projetgrh.service;

import org.sid.projetgrh.Profession;
import org.sid.projetgrh.dao.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessionRestService {
    @Autowired
    ProfessionRepository  ProfessionRepository;

    @GetMapping(value = "/ProfessionList")
    public List<Profession> professionList(){
        return ProfessionRepository.findAll();

    }

    @GetMapping(value = "/ProfessionList/{idProfession}")
    public Profession professionList (@PathVariable(name = "idProfession")long idProfession){
        return  ProfessionRepository.findById(idProfession).get();

    }

    @PutMapping(value = "/ProfessionList/{idProfession}")
    public Profession  update(@PathVariable(name = "idProfession")long idProfession,@RequestBody Profession r){
        return ProfessionRepository.save(r);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/ProfessionList")
    public Profession save(@RequestBody Profession r){
        return ProfessionRepository.save(r);
    }

    @DeleteMapping (value = "/ProfessionList/{idProfession}")
    public void delete(@PathVariable(name = "idProfession")long idProfession){

        ProfessionRepository.deleteById(idProfession);

    }

}
