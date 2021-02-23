package org.sid.projetgrh.service;


import org.sid.projetgrh.AvanceSalaire;
import org.sid.projetgrh.Displine;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.DisplineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisplineRestService {
    @Autowired
    DisplineRepository DisplineRepository ;

    public List<Displine> ListDispline(){
        return DisplineRepository.findAll();

    }
    public Displine findByIdDi(@PathVariable(name = "idDispline")long idDispline){
        return DisplineRepository.findById(idDispline).get();
    }

    public Displine updateD(long idDispline, @RequestBody Displine Di){
        return DisplineRepository.save(Di);

    }

    public Displine saveDi(Displine Di){
        return DisplineRepository.save(Di);
    }

    public void deleteDi(long idDispline){
        DisplineRepository.deleteById(idDispline);
    }
























/*
    @GetMapping(value = "/DisplineList")
    public List<Displine> displineList(){

      return displineList().stream().map(displine -> {
            return Displine.builder()
                    .idDispline(displine.getIdDispline())
                    .typeDispline(displine.getIdDispline())
                    .nomSuperviseur(displine.getNomSuperviseur())
                    .date(displine.getDate())
                    .Description(displine.getDescription())
                    .Demande_explication(displine.getDemande_explication())
                    .employe(Employe.builder().idEmploye(displine.getIdDispline()).nom(displine.getEmploye().getNom()).build())
                    .build();
        }).collect(Collectors.toList());


        return DisplineRepository.findAll();

    }

    @GetMapping(value = "/DisplineList/{idDispline}")
    public Displine displineList(@PathVariable(name = "idDispline")long idDispline){
        return  DisplineRepository.findById(idDispline).get();

    }

    @PutMapping(value = "/DisplineList/{idDispline}")
    public Displine update(@PathVariable(name = "idDispline")long idDispline,@RequestBody Displine d ){
        return DisplineRepository.save(d);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/DisplineList")
    public Displine save(@RequestBody Displine d){
        return DisplineRepository.save(d);
    }

    @DeleteMapping (value = "/DisplineList/{idDispline}")
    public void delete(@PathVariable(name = "idDispline")long idDispline){

        DisplineRepository.deleteById(idDispline);

    }




*/
}
