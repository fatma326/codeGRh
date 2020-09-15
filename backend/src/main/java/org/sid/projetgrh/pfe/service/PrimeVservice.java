package org.sid.projetgrh.pfe.service;


import org.sid.projetgrh.pfe.dao.PrimeVarRep;
import org.sid.projetgrh.pfe.entities.Primevariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PrimeVservice {


    @Autowired
    private PrimeVarRep primeVarRep;

    public List<Primevariable> listPrimeV(){
        return primeVarRep.findAll();
    }

    public Primevariable findById(@PathVariable(name = "IdprimeV") long IdprimeV){
        return primeVarRep.findById(IdprimeV).get();
    }

    public Primevariable updatePrv(long IdprimeV, @RequestBody Primevariable Pv)
    {
        return primeVarRep.save(Pv);
    }

    public Primevariable savePrv(Primevariable Pv){

        return primeVarRep.save(Pv);
    }

    public void deletePrv(long IdprimeV){

        primeVarRep.deleteById(IdprimeV);
    }


}
