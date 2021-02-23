package org.sid.projetgrh.web;

import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.service.AvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class AvanceContr {

    @Autowired
    private AvanceService avanceService;


    @GetMapping(value = "/ListAvance")
    public List<AvanceSalaire> ListAvance(){
        return avanceService.ListAvance().stream().map(avanceSalaire -> {
            return AvanceSalaire.builder()
                    .idAvance(avanceSalaire.getIdAvance())
                    .date_affectation(avanceSalaire.getDate_affectation())
                    .mois(avanceSalaire.getMois())
                    .type(avanceSalaire.getType())
                    .valeur(avanceSalaire.getValeur())
                    .employe(avanceSalaire.getEmploye() != null ? Employe.builder().idEmploye(avanceSalaire.getEmploye().getIdEmploye()).nom(avanceSalaire.getEmploye().getNom()).build():null)
                    .build();



        }).collect(Collectors.toList());
    }
//2
    @PostMapping(value = "/ListAvance")
    public AvanceSalaire saveA(@RequestBody AvanceSalaire Av){
        return avanceService.saveAv(Av);
    }

    @PutMapping(value = "/ListAvance/{idAvance}")
    public AvanceSalaire updateA(@PathVariable(name = "idAvance")long idAvance, @RequestBody AvanceSalaire Av){
        Av.setIdAvance(idAvance);
        return avanceService.saveAv(Av);
    }
//1
    @GetMapping(value = "/ListAvance/{idAvance}")
    public AvanceSalaire getByIdA(@PathVariable(name = "idAvance")long idAvance){
        return avanceService.findByIdAv(idAvance);
    }

    @DeleteMapping(value = "/ListAvance/{idAvance}")
    public void deleteA(@PathVariable(name = "idAvance")long idAvance){
        avanceService.deleteAv(idAvance);
    }
}
