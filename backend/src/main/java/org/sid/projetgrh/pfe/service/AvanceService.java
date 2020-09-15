package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.AvanceRep;
import org.sid.projetgrh.pfe.entities.AvanceSalaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class AvanceService {

    @Autowired
    private AvanceRep avanceRep;

    public List<AvanceSalaire> ListAvance(){
        return avanceRep.findAll();

    }
    public AvanceSalaire findByIdAv(@PathVariable(name = "idAvance")long idAvance){
        return avanceRep.findById(idAvance).get();
    }

    public AvanceSalaire updateA(long idAvance, @RequestBody AvanceSalaire Av){
        return avanceRep.save(Av);

    }

    public AvanceSalaire saveAv(AvanceSalaire Av){
        return avanceRep.save(Av);
    }

    public void deleteAv(long idAvance){
        avanceRep.deleteById(idAvance);
    }






}
