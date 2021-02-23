package org.sid.projetgrh.service;

import org.sid.projetgrh.Fonction;
import org.sid.projetgrh.dao.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FonctionRestService {

    @Autowired
    FonctionRepository FonctionRepository;

    @GetMapping(value = "/FonctionList")
    public List<Fonction> fonctionList(){
        return FonctionRepository.findAll();

    }

    @GetMapping(value = "/FonctionList/{idFonction}")
    public Fonction  fonctionList(@PathVariable(name = "idFonction")long idFonction){
        return  FonctionRepository.findById(idFonction).get();

    }

    @PutMapping(value = "/FonctionList/{idFonction}")
    public Fonction update(@PathVariable(name = "idFonction")long idFonction,@RequestBody Fonction f){
        return FonctionRepository.save(f);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/FonctionList")
    public Fonction save(@RequestBody Fonction f){
        return FonctionRepository.save(f);
    }

    @DeleteMapping (value = "/FonctionList/{idFonction}")
    public void delete(@PathVariable(name = "idFonction")long idFonction){

        FonctionRepository.deleteById(idFonction);

    }




}
