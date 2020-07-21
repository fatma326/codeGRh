package org.sid.projetgrh;

import org.sid.projetgrh.dao.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeRestService {
    @Autowired
    private EmployeRepository employeRepository;

    @GetMapping(value = "/listemployes")
    public List<Employe> listEmployes(){
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
