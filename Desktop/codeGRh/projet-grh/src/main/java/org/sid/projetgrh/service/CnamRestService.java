package org.sid.projetgrh.service;


import org.sid.projetgrh.CNAM;
import org.sid.projetgrh.dao.CnamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CnamRestService {

@Autowired
    CnamRepository CnamRepository;


    @GetMapping(value = "/CnamList")
    public List<CNAM> CnamList(){
        return CnamRepository.findAll();

    }

    @GetMapping(value = "/CnamList/{idCnam}")
    public CNAM CnamList(@PathVariable(name = "idCnam")long idCnam){
        return  CnamRepository.findById(idCnam).get();

    }

    @PutMapping(value = "/CnamList/{idCnam}")
    public CNAM update(@PathVariable(name = "idCnam")long idCnam,@RequestBody CNAM n ){
        return CnamRepository.save(n);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/CnamList")
    public CNAM save(@RequestBody CNAM n){
        return CnamRepository.save(n);
    }

    @DeleteMapping (value = "/CnamList/{idCnam}")
    public void delete(@PathVariable(name = "idCnam")long idCnam){

        CnamRepository.deleteById(idCnam);

    }




}
