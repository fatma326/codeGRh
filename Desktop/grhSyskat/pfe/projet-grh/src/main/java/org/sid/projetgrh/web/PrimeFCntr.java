package org.sid.projetgrh.web;

import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Primefixe;
import org.sid.projetgrh.Primevariable;
import org.sid.projetgrh.service.PrimeFservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PrimeFCntr {

    @Autowired
    private PrimeFservice primeFservice;


    @GetMapping(value = "/listPrimeF")
    public List<Primefixe> listPrimeF() {
        return primeFservice.listPrimeF().stream().map(primefixe -> {
            return Primefixe.builder()
                    .IdprimeF(primefixe.getIdprimeF())
                    .nomPrime(primefixe.getNomPrime())
                    .Code_Prime(primefixe.getCode_Prime())
                    .valeur_prime(primefixe.getValeur_prime())
                    .date_primefx(primefixe.getDate_primefx())
                    .employe(primefixe.getEmploye() != null ? Employe.builder().idEmploye(primefixe.getEmploye().getIdEmploye()).nom(primefixe.getEmploye().getNom()).build():null)
                    .build();
        }).collect(Collectors.toList());



    }


    @PostMapping(value = "/listPrimeF")
    public Primefixe saveP1(@RequestBody Primefixe Pf){
        return primeFservice.savePrf(Pf);
    }


    @PutMapping(value = "/listPrimeF/{IdprimeF}")
    public Primefixe  updateP(@PathVariable(name = "IdprimeF")long IdprimeF, @RequestBody Primefixe Pf){
        Pf.setIdprimeF(IdprimeF);
        return primeFservice.savePrf(Pf);

    }
    @GetMapping(value = "/listPrimeF/{IdprimeF}")
    public Primefixe  getById(@PathVariable(name = "IdprimeF")long IdprimeF){
        return primeFservice.findById(IdprimeF);

    }

    @DeleteMapping(value = "/listPrimeF/{IdprimeF}")
    public void deleteP(@PathVariable(name = "IdprimeF")long IdprimeF){

        primeFservice.deletePrf(IdprimeF);
    }

}
