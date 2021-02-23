package org.sid.projetgrh.service;

import org.sid.projetgrh.Conges;
import org.sid.projetgrh.Departement;
import org.sid.projetgrh.dao.derpartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DepartementRestService {
    @Autowired
    derpartementRepository derpartementRepository;


    public List<Departement> depList(){
        return derpartementRepository.findAll();
        }

    public Departement findById(long id){

        return  derpartementRepository.findById(id).get();
    }

    public Departement update(@PathVariable(name = "id")long id,@RequestBody Departement d ){
        return derpartementRepository.save(d);
    }

    public Departement save( Departement d){
        return derpartementRepository.save(d);
    }

    public void delete(@PathVariable(name = "id")long id){
        derpartementRepository.deleteById(id);
    }
}
