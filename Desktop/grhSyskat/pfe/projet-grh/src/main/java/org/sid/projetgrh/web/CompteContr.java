package org.sid.projetgrh.web;

import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Compte;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class CompteContr {

    @Autowired
    private CompteService compteService;

    @GetMapping(value = "/listDsCmpts")
    public List<Compte> listDsCmpts(){
        return compteService.listDsCmpts().stream().map(compte -> {
            return Compte.builder()
                .idCmpte(compte.getIdCmpte())
                .numerCmpte(compte.getNumerCmpte())
                .nomBanque(compte.getNomBanque())
                .employe(compte.getEmploye() != null ? Employe.builder().idEmploye(compte.getEmploye().getIdEmploye()).nom(compte.getEmploye().getNom()).build():null)
                .build();
         }).collect(Collectors.toList());


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
