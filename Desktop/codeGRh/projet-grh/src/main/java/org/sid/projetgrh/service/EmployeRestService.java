package org.sid.projetgrh.service;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.Primefixe;
import org.sid.projetgrh.Primevariable;
import org.sid.projetgrh.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    private PointgeRepository pointgeRepository;

    @Autowired
    private CnssRepository cnssRepository;
    @Autowired
    private CnamRepository cnamRepository;

    @GetMapping(value = "/listemployes")
    public List<Employe> listEmployes() {
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
    public Employe listEmployes(@PathVariable(name = "idEmploye") long idEmploye) {
        return employeRepository.findById(idEmploye).get();

    }

    @PutMapping(value = "/listemployes/{idEmploye}")
    public Employe update(@PathVariable(name = "idEmploye") long idEmploye, @RequestBody Employe p) {
        // p.setIdEmploye(idEmploye);
        return employeRepository.save(p);

    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(value = "/listemployes")
    public Employe save(@RequestBody Employe p) {
        return employeRepository.save(p);
    }

    @DeleteMapping(value = "/listemployes/{idEmploye}")
    public void delete(@PathVariable(name = "idEmploye") long idEmploye) {

        employeRepository.deleteById(idEmploye);

    }

    @GetMapping(value = "/bultinSalaire/{idEmploye}")
    public HashMap getBultinSalaire(@PathVariable(name = "idEmploye") long idEmploye) {
        Employe e = employeRepository.getOne(idEmploye);
        List<Pointage> pointages = pointgeRepository.findAllByEmploye(e);
        HashMap res = new HashMap<String, Object>();

        double tauxHor = e.getSalBase() / (172.33);

        float sommeHeureNormale = 0;
        float sommeHeureSup = 0;

        for (Pointage p : pointages) {
            long milliseconds1 = p.getHeures_entree().getTime();
            long milliseconds2 = p.getHeures_sortie().getTime();

            long diff = milliseconds2 - milliseconds1;
            long diffSeconds = diff / 1000;
            long diffMinutes = diff / (60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);

            sommeHeureNormale += diffHours;
            sommeHeureSup += p.getHeursSup();
        }

        double mntPointage = sommeHeureNormale / tauxHor;

        double sommePrime = e.getPrimefixe().get(0).getValeur_prime() + e.getPrimevariable().get(0).getValeur_prime();

        double sommeGain = sommePrime + mntPointage;
        double primeSalBase = sommePrime + e.getSalBase();
        double cnam = (4 * primeSalBase) / 100;

        double plafondSalCnss = cnssRepository.getOne(Long.parseLong("1")).getPlafondSalarial();

        int nbrPlafondInSal = (int) (e.getSalBase() / plafondSalCnss);

        double percentCnss = cnssRepository.getOne(Long.parseLong("1")).getPourcentageCnss();

        double sommeMntCnss = 0;

        if (e.getSalBase() > plafondSalCnss) {
            sommeMntCnss = nbrPlafondInSal * (percentCnss * plafondSalCnss);
        }

        res.put("montant cnss à payer", sommeMntCnss);
        res.put("montant cnam à payer", cnam);
        res.put("montant primes", sommePrime);
        res.put("salaireBrut", mntPointage);
        return res;
    }

}
