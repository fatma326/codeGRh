package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.PointgeRepository;
import org.sid.projetgrh.pfe.dao.PretsRep;
import org.sid.projetgrh.pfe.entities.Prets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class pretsService {

    @Autowired
    private PretsRep pretsRep;

    public List<Prets> listPrets(){
        return pretsRep.findAll();

    }
    public Prets findById(@PathVariable(name = "IdPrets")long IdPrets){

        return pretsRep.findById(IdPrets).get();
    }

    public Prets updatePr(long IdPrets, @RequestBody Prets Pr){
        return pretsRep.save(Pr);

    }

    public Prets savePrs(Prets Pr){
        return pretsRep.save(Pr);
    }

    public void deletePrs(long IdPrets){

        pretsRep.deleteById(IdPrets);
    }

}
