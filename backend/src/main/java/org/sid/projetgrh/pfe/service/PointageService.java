package org.sid.projetgrh.pfe.service;

import org.sid.projetgrh.pfe.dao.PointgeRepository;
import org.sid.projetgrh.pfe.entities.Pointage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class PointageService {

    @Autowired
    private PointgeRepository pointgeRepository;

    public List<Pointage> listPointee(){
        return pointgeRepository.findAll();

    }
    public Pointage findById(@PathVariable(name = "idPointage")long idPointage){
        return pointgeRepository.findById(idPointage).get();
    }

    public Pointage updateP(long idPointage, @RequestBody Pointage Pn){
        return pointgeRepository.save(Pn);

    }

    public Pointage saveP(Pointage Pn){
        return pointgeRepository.save(Pn);
    }

    public void deleteP(long idPointage){

        pointgeRepository.deleteById(idPointage);
    }








}
