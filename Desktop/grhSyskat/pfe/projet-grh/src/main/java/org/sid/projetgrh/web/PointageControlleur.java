package org.sid.projetgrh.web;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.service.PointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PointageControlleur {

    @Autowired
    private PointageService pointgeService;

    @GetMapping(value = "/listPointee")
    public List<Pointage> listPointee()
    {
        return pointgeService.listPointee().stream().map(pointage -> {
            return Pointage.builder()
                    .absence(pointage.getAbsence())
                    .Date_Pointage(pointage.getDate_Pointage())
                    .heures_entree(pointage.getHeures_entree())
                    .heures_sortie(pointage.getHeures_sortie())
                    .heursSup(pointage.getHeursSup())
                    .HeureTotal(pointage.getHeureTotal())
                    .tauxHorraire(pointage.getTauxHorraire())
                    .type_absence(pointage.getType_absence())
                    .idPointage(pointage.getIdPointage())
                    .employe(Employe.builder().idEmploye(pointage.getIdPointage()).nom(pointage.getEmploye().getNom()).build())
                    .build();
        }).collect(Collectors.toList());
    }

    @PostMapping(value = "/listPointee")
    public Pointage saveP1(@RequestBody Pointage Pn){
        return pointgeService.saveP(Pn);
    }

    @PutMapping(value = "/listPointee/{idPointage}")
    public Pointage  updateP(@PathVariable(name = "idPointage")long idPointage, @RequestBody Pointage Pn){
        Pn.setIdPointage(idPointage);
        return pointgeService.saveP(Pn);

    }
    @GetMapping(value = "/listPointee/{idPointage}")
    public Pointage  getById(@PathVariable(name = "idPointage")long idPointage){
        return pointgeService.findById(idPointage);

    }

    @DeleteMapping(value = "/listPointee/{idPointage}")
    public void deleteP(@PathVariable(name = "idPointage")long idPointage){

        pointgeService.deleteP(idPointage);
    }


}
