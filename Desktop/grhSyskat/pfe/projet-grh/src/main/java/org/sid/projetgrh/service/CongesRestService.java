package org.sid.projetgrh.service;
import org.sid.projetgrh.Conges;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.CongesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CongesRestService {

    @Autowired
    CongesRepository CongesRepository;

    public List<Conges> CongesList(){
        return CongesRepository.findAll();

    }
    public Conges findByIdC(@PathVariable(name = "idConges")long idConges){
        return CongesRepository.findById(idConges).get();
    }

    public Conges updateC(long idConges, @RequestBody Conges Co){
        return CongesRepository.save(Co);

    }

    public Conges saveC(Conges Co){
        return CongesRepository.save(Co);
    }

    public void deleteC(long idConges){
        CongesRepository.deleteById(idConges);
    }















}
