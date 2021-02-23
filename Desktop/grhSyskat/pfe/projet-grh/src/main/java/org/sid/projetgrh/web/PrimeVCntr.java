package org.sid.projetgrh.web;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Primevariable;
import org.sid.projetgrh.service.PrimeVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class PrimeVCntr {



    @Autowired
    private PrimeVservice primeVservice;

    @GetMapping(value = "/listPrimeV")
    public List<Primevariable> listPrimeV()
    {
       return primeVservice.listPrimeV().stream().map(primevariable -> {
            return Primevariable.builder()
                    .Code_Prime(primevariable.getCode_Prime())
                    .date_primeVr(primevariable.getDate_primeVr())
                    .IdprimeV(primevariable.getIdprimeV())
                    .nomPrimeV(primevariable.getNomPrimeV())
                    .valeur_prime(primevariable.getValeur_prime())
                    .employe(primevariable.getEmploye() != null ? Employe.builder().idEmploye(primevariable.getEmploye().getIdEmploye()).nom(primevariable.getEmploye().getNom()).build():null)
                    .build();


        }).collect(Collectors.toList());
    }

    @PostMapping(value = "/listPrimeV")
    public Primevariable saveP1(@RequestBody Primevariable Pv){

        return primeVservice.savePrv(Pv);
    }

    @PutMapping(value = "/listPrimeV/{IdprimeV}")
    public Primevariable  updateP(@PathVariable(name = "IdprimeV")long IdprimeV, @RequestBody Primevariable Pv){
        Pv.setIdprimeV(IdprimeV);
        return primeVservice.savePrv(Pv);

    }
    @GetMapping(value = "/listPrimeV/{IdprimeV}")
    public Primevariable  getById(@PathVariable(name = "IdprimeV")long IdprimeV){
        return primeVservice.findById(IdprimeV);

    }

    @DeleteMapping(value = "/listPrimeV/{IdprimeV}")
    public void deleteP(@PathVariable(name = "IdprimeV")long IdprimeV){

        primeVservice.deletePrv(IdprimeV);
    }

}
