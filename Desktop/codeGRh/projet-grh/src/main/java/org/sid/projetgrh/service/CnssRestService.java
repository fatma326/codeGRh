package org.sid.projetgrh.service;


import org.sid.projetgrh.CNSS;
import org.sid.projetgrh.dao.CnssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CnssRestService {
    @Autowired
    CnssRepository CnssRepository;


    @GetMapping(value = "/CnssList")
    public List<CNSS> CnssList(){
        return CnssRepository.findAll();

    }

    @GetMapping(value = "/CnssList/{idCnss}")
    public CNSS  CnssList(@PathVariable(name = "idCnss")long idCnss){
        return  CnssRepository.findById(idCnss).get();

    }

    @PutMapping(value = "/CnssList/{idCnss}")
    public CNSS update(@PathVariable(name = "idCnss")long idCnss,@RequestBody CNSS s ){
        return CnssRepository.save(s);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/CnssList")
    public CNSS save(@RequestBody CNSS s){
        return CnssRepository.save(s);
    }

    @DeleteMapping (value = "/CnssList/{idCnss}")
    public void delete(@PathVariable(name = "idCnss")long idCnss){

        CnssRepository.deleteById(idCnss);

    }





}
