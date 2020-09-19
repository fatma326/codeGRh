package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Employe;
import org.sid.projetgrh.pfe.entities.Pointage;
import org.sid.projetgrh.pfe.service.EmployeRestService;
import org.sid.projetgrh.pfe.service.PointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PointageControlleur {

    @Autowired
    private PointageService pointgeService;

    @Autowired
    private EmployeRestService employeRestService;

    @GetMapping(value = "/listPointee")
    public List<Pointage> listPointee()
    {
        return pointgeService.listPointee();
    }

    @PostMapping(value = "/listPointee")
    public Pointage saveP1(@RequestBody Pointage Pn){
        return pointgeService.saveP(Pn);
    }

    @PutMapping(value = "/listPointee/{idPointage}")
    public Pointage  updateP(@PathVariable(name = "idPointage")long idPointage, @RequestBody Pointage pn){
        pn.setIdPointage(idPointage);
        Employe employe = employeRestService.findByIdE(pn.getEmploye().getIdEmploye());
        pn.setEmploye(employe);
        return pointgeService.saveP(pn);

    }
    @GetMapping(value = "/listPointee/{idPointage}")
    public Pointage  getById(@PathVariable(name = "idPointage")long idPointage){
        return pointgeService.findById(idPointage);

    }

    @DeleteMapping (value = "/listPointee/{idPointage}")
    public void deleteP(@PathVariable(name = "idPointage")long idPointage){

        pointgeService.deleteP(idPointage);
    }


}
