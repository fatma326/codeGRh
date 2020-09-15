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

    public List<Employe> listemployes(){
        return employeRepository.findAll();

    }

    @GetMapping(value = "/recherche-employes")
    public List<Employe> rechercheEmploye(@RequestParam(defaultValue = "") String nom, @RequestParam(defaultValue = "") String prenom, @RequestParam(defaultValue = "0") int nni)
    {
        if(nni > 0)
        {
            return employeRepository.findByNomContainsAndPrenomContainsAndNniEquals(nom, prenom, nni);
        }
        else
        {
            return employeRepository.findByNomContainsAndPrenomContains(nom, prenom);
        }

    }

    public Employe  listEmployes(@PathVariable(name = "idEmploye")long idEmploye){
        return employeRepository.findById(idEmploye).get();
    }

    public Employe  update(long idEmploye,@RequestBody Employe p)
    {
        return employeRepository.save(p);
    }

    public Employe findByIdE(@PathVariable(name = "idEmploye")long idEmploye){
        return employeRepository.findById(idEmploye).get();
    }

    public Employe saveE(Employe p){ return employeRepository.save(p); }

    public void delete(long idEmploye){
        employeRepository.deleteById(idEmploye);
    }

}
