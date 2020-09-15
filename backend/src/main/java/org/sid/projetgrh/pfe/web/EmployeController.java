package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Employe;
import org.sid.projetgrh.pfe.service.EmployeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeController {

    @Autowired
    EmployeRestService employeRestService;


    @GetMapping(value = "/listemployes")
    public List<Employe> listemployes(){
        return employeRestService.listemployes();
    }

    @PostMapping(value = "/listemployes")
    public Employe saveEm(@RequestBody Employe p){
        return employeRestService.saveE(p);
    }

    @PutMapping (value = "/listemployes/{idEmploye}")
    public Employe  update(@PathVariable(name = "idEmploye")long idEmploye, @RequestBody Employe p){
        p.setIdEmploye(idEmploye);
        return employeRestService.saveE(p);

    }

    @GetMapping(value = "/listemployes/{idEmploye}")
    public Employe getByIdE(@PathVariable(name = "idEmploye")long idEmploye){
        return employeRestService.findByIdE(idEmploye);

    }

    @DeleteMapping (value = "/listemployes/{idEmploye}")
    public void delete(@PathVariable(name = "idEmploye")long idEmploye){
        employeRestService.delete(idEmploye);
    }

}
