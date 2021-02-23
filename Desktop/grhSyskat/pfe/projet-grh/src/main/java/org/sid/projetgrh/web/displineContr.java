package org.sid.projetgrh.web;


import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Displine;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.service.DisplineRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class displineContr {
    @Autowired
    DisplineRestService displineRestService;

    @GetMapping(value = "/DisplineList")
    public List<Displine> ListDispline(){
        return displineRestService.ListDispline().stream().map(displine -> {
            return Displine.builder()
                    .idDispline(displine.getIdDispline())
                    .typeDispline(displine.getTypeDispline())
                    .nomSuperviseur(displine.getNomSuperviseur())
                    .date(displine.getDate())
                    .Description(displine.getDescription())
                    .Demande_explication(displine.getDemande_explication())
                    .employe(displine.getEmploye() != null ? Employe.builder().idEmploye(displine.getEmploye().getIdEmploye()).nom(displine.getEmploye().getNom()).build():null)
                    .build();
        }).collect(Collectors.toList());
    }


    @PostMapping(value = "/DisplineList")
    public Displine saveD(@RequestBody Displine Di){

        return displineRestService.saveDi(Di);
    }

    @PutMapping(value = "/DisplineList/{idDispline}")
    public Displine updateD(@PathVariable(name = "idDispline")long idDispline, @RequestBody Displine Di){
        Di.setIdDispline(idDispline);
        return displineRestService.saveDi(Di);
    }

    @GetMapping(value = "/DisplineList/{idDispline}")
    public Displine getByIdD(@PathVariable(name = "idDispline")long idDispline){
        return displineRestService.findByIdDi(idDispline);
     }


    @DeleteMapping(value = "/DisplineList/{idDispline}")
    public void deleteA(@PathVariable(name = "idDispline")long idDispline){
        displineRestService.deleteDi(idDispline);
    }
}
