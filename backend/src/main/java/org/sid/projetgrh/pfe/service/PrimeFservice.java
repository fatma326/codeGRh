package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.PrimeFixeRep;
import org.sid.projetgrh.pfe.entities.Primefixe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PrimeFservice {

    @Autowired
    private PrimeFixeRep primeFixeRep;

    public List<Primefixe> listPrimeF()
    {
        return primeFixeRep.findAll();
    }

    public Primefixe findById(@PathVariable(name = "IdprimeF") long IdprimeF){
        return primeFixeRep.findById(IdprimeF).get();
    }

    public Primefixe updatePrf(long IdprimeF, @RequestBody Primefixe Pf){
        return primeFixeRep.save(Pf);
    }

    public Primefixe savePrf(Primefixe Pf){
        return primeFixeRep.save(Pf);
    }

    public void deletePrf(long IdprimeF){
        primeFixeRep.deleteById(IdprimeF);
    }


}
