package org.sid.projetgrh.web;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.Prets;
import org.sid.projetgrh.service.pretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PretsCntr {


    @Autowired
    private pretsService pservice ;

    @GetMapping(value = "/listPrets")
    public List<Prets> listPrets()
    {
        return pservice.listPrets().stream().map(prets -> {
            return Prets.builder()
                    .IdPrets(prets.getIdPrets())
                    .montant(prets.getMontant())
                    .retenu_mensuel(prets.getMontant())
                    .date_affectation(prets.getDate_affectation())
                    .nbre_mois(prets.getNbre_mois())
                    .employe(prets.getEmploye() != null ? Employe.builder().idEmploye(prets.getEmploye().getIdEmploye()).nom(prets.getEmploye().getNom()).build():null)
                    .build();
        }).collect(Collectors.toList());




    }

    @PostMapping(value = "/listPrets")
    public Prets saveP1(@RequestBody Prets Pr){

        return pservice.savePrs(Pr);
    }

    @PutMapping(value = "/listPrets/{IdPrets}")
    public Prets  updateP(@PathVariable(name = "IdPrets")long IdPrets, @RequestBody Prets Pr){
        Pr.setIdPrets(IdPrets);
        return pservice.savePrs(Pr);

    }
    @GetMapping(value = "/listPrets/{IdPrets}")
    public Prets  getById(@PathVariable(name = "IdPrets")long IdPrets){
        return pservice.findById(IdPrets);

    }

    @DeleteMapping(value = "/listPrets/{IdPrets}")
    public void deleteP(@PathVariable(name = "IdPrets")long IdPrets){

        pservice.deletePrs(IdPrets);
    }



}
