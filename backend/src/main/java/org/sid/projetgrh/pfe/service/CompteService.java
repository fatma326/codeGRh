package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.CmpteRep;
import org.sid.projetgrh.pfe.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CompteService {

    @Autowired
    private CmpteRep cmpterep;


    public List<Compte> listDsCmpts(){
        return cmpterep.findAll();

    }
    public Compte findByIdCp(@PathVariable(name = "idCmpte")long idCmpte){

        return cmpterep.findById(idCmpte).get();
    }

    public Compte updateCp(long idCmpte, @RequestBody Compte cn){
        return cmpterep.save(cn);

    }

    public Compte saveCp(Compte cn){
        return cmpterep.save(cn);
    }

    public void deleteCp(long idCmpte){
        cmpterep.deleteById(idCmpte);
    }


}
