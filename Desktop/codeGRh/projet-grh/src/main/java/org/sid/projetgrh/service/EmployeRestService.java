package org.sid.projetgrh.service;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.Primefixe;
import org.sid.projetgrh.Primevariable;
import org.sid.projetgrh.dao.EmployeRepository;
import org.sid.projetgrh.dao.PointgeRepository;
import org.sid.projetgrh.dao.PrimeFixeRep;
import org.sid.projetgrh.dao.PrimeVarRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;



@RestController
public class EmployeRestService {
    @Autowired
    private EmployeRepository employeRepository;
    @Autowired
    private PrimeFixeRep primeFixeRep;
    @Autowired
    private PrimeVarRep primeVarRep;
    @Autowired
    private PointgeRepository PointgeRepository;

    @GetMapping(value = "/listemployes")
    public List<Employe> listEmployes(){
        List<Employe> employes = employeRepository.findAll();
        return employes;
    }

    /* @GetMapping(value = "/recherche-employes")
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
       
    }*/
    
    @GetMapping(value = "/listemployes/{idEmploye}")
    public Employe  listEmployes(@PathVariable(name = "idEmploye")long idEmploye){
        return employeRepository.findById(idEmploye).get();

    }

    @PutMapping (value = "/listemployes/{idEmploye}")
    public Employe  update(@PathVariable(name = "idEmploye")long idEmploye,@RequestBody Employe p){
       // p.setIdEmploye(idEmploye);
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

    @GetMapping(value = "/bultinSalaire/{idEmploye}")
    public HashMap  getBultinSalaire(@PathVariable(name = "idEmploye")long idEmploye){
        HashMap res = new HashMap<String, Object>() ;
        double salBase;

        Employe e = employeRepository.findById(idEmploye).get();
        salBase = e.getSalBase();

        int primesFixes = 0;
        // TODO: where date in this month
        List<Primefixe> primefixes = primeFixeRep.getPrimefixeByEmploye(e);
        for (Primefixe pf: primefixes ) {
            primesFixes += pf.getValeur_prime();
        }

        int Pointage = 0;
        List<Pointage> Pointages = PointgeRepository.getPointageByEmploye(e);
        for(Pointage p: Pointages) {
            Pointage += p.getHeures_entree();
            Pointage += p.getHeures_sortie();



     }

        int primesVariable = 0;
        List<Primevariable> primevariables = primeVarRep.getPrimevariableByEmploye(e);
        for(Primevariable pv: primevariables) {
            primesVariable += pv.getValeur_prime();

        }


        int pret = 0;
        int avanceSurSalaire = 0;
        int cnam = 1500;
        int cnss = 1200;
        int its = 2000;
        int ancienete = 0;

        res.put("idUser", idEmploye);
        res.put("salBase", salBase);
        res.put("primesFixes", primesFixes);
        res.put("primesVariable", primesVariable);
        res.put("heuresSupp", Pointage);
        res.put("pret", pret);
        res.put("avanceSurSalaire", avanceSurSalaire);
        res.put("cnam", cnam);
        res.put("cnss", cnss);
        res.put("its", its);
        res.put("ancienete", ancienete);
        return res;
    }

}
