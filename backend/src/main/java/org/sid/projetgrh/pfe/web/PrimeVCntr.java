package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Primevariable;
import org.sid.projetgrh.pfe.service.PrimeVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PrimeVCntr {



    @Autowired
    private PrimeVservice primeVservice;

    @GetMapping(value = "/listPrimeV")
    public List<Primevariable> listPrimeV()
    {
        return primeVservice.listPrimeV();
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

    @DeleteMapping (value = "/listPrimeV/{IdprimeV}")
    public void deleteP(@PathVariable(name = "IdprimeV")long IdprimeV){

        primeVservice.deletePrv(IdprimeV);
    }

}
