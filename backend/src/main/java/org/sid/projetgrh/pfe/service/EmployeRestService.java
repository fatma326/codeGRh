package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.EmployeRepository;
import org.sid.projetgrh.pfe.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EmployeRestService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> listEmployes(){
        return employeRepository.findAll();

    }
    @GetMapping(value = "/listemployes/{idEmploye}")
    public Employe  listEmployes(@PathVariable(name = "idEmploye")long idEmploye){
        return employeRepository.findById(idEmploye).get();

    }

    @PutMapping (value = "/listemployes/{idEmploye}")
    public Employe  update(@PathVariable(name = "idEmploye")long idEmploye,@RequestBody Employe p){
        p.setIdEmploye(idEmploye);
        return employeRepository.save(p);

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/listemployes")
    public Employe save(@RequestBody Employe p){
        return employeRepository.save(p);
    }

    @DeleteMapping (value = "/listemployes/{idEmploye}")
    public void delete(@PathVariable(name = "idEmploye")long idEmploye){

        employeRepository.deleteById(idEmploye);

    }


}
