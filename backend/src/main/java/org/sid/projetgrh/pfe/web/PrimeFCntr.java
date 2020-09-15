package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Primefixe;
import org.sid.projetgrh.pfe.service.PrimeFservice;
import org.sid.projetgrh.pfe.service.PrimeVservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PrimeFCntr {

    @Autowired
    private PrimeFservice primeFservice;


    @GetMapping(value = "/listPrimeF")
    public List<Primefixe> listPrimeF() {
        return primeFservice.listPrimeF();
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

    @DeleteMapping (value = "/listPrimeF/{IdprimeF}")
    public void deleteP(@PathVariable(name = "IdprimeF")long IdprimeF){

        primeFservice.deletePrf(IdprimeF);
    }

}
