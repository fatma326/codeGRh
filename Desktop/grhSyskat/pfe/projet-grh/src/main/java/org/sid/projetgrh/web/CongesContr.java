package org.sid.projetgrh.web;
import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Conges;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.service.CongesRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
public class CongesContr {
    @Autowired
    CongesRestService congesRestService;

    @GetMapping(value = "/CongesList")
    public List<Conges> CongesList(){
        return congesRestService.CongesList().stream().map(conges -> {
            return Conges.builder()
                    .idConges(conges.getIdConges())
                    .duree(conges.getDuree())
                    .dateDebut(conges.getDateDebut())
                    .type(conges.getType())
                    .employe(conges.getEmploye() != null ? Employe.builder().idEmploye(conges.getEmploye().getIdEmploye()).nom(conges.getEmploye().getNom()).build():null)
                    .build();
// .employe(conges.getEmploye() != null ? Employe.builder().idEmploye(conges.getEmploye().getIdEmploye()).nom(conges.getEmploye().getNom()).build() : null)
//
        }).collect(Collectors.toList());

    }

    @PostMapping(value = "/CongesList")
    public Conges saveC(@RequestBody Conges Co){
        return congesRestService.saveC(Co);
    }

    @PutMapping(value = "/CongesList/{idConges}")
    public Conges updateC(@PathVariable(name = "idConges")long idConges, @RequestBody Conges Co){
        Co.setIdConges(idConges);
        return congesRestService.saveC(Co);
    }

    @GetMapping(value = "/CongesList/{idConges}")
    public Conges getByIdC(@PathVariable(name = "idConges")long idConges){
        return congesRestService.findByIdC(idConges);
    }


    @DeleteMapping(value = "/CongesList/{idConges}")
    public void deleteC(@PathVariable(name = "idConges")long idConges){
        congesRestService.deleteC(idConges);
    }
}




