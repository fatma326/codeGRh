package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Compte;
import org.sid.projetgrh.pfe.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CompteContr {

    @Autowired
    private CompteService compteService;

    @GetMapping(value = "/listDsCmpts")
    public List<Compte> listDsCmpts(){
        return compteService.listDsCmpts();
    }

    @PostMapping(value = "/listDsCmpts")
    public Compte saveC(@RequestBody Compte cn) {
        return compteService.saveCp(cn);
    }

    @PutMapping(value = "/listDsCmpts/{idCmpte}")
    public Compte updateCP(@PathVariable(name = "idCmpte")long idCmpte, @RequestBody Compte cn){
        cn.setIdCmpte(idCmpte);
        return compteService.saveCp(cn);
    }

    @GetMapping(value = "/listDsCmpts/{idCmpte}")
    public Compte getByIdC(@PathVariable(name = "idCmpte")long idCmpte){
        return compteService.findByIdCp(idCmpte);
    }

    @DeleteMapping(value = "/listDsCmpts/{idCmpte}")
    public void deleteCP(@PathVariable(name = "idCmpte")long idCmpte){
        compteService.deleteCp(idCmpte);
    }





}
