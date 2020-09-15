package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Pointage;
import org.sid.projetgrh.pfe.entities.Prets;
import org.sid.projetgrh.pfe.service.pretsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PretsCntr {


    @Autowired
    private pretsService pservice ;

    @GetMapping(value = "/listPrets")
    public List<Prets> listPrets()
    {
        return pservice.listPrets();
    }

    @PostMapping(value = "/listPrets")
    public Prets saveP1(@RequestBody Prets Pr){

        return pservice.savePrs(Pr);
    }

    @PutMapping(value = "/listPrets/{IdPrets}")
    public Prets  updateP(@PathVariable(name = "IdPrets")long IdPrets, @RequestBody Prets Pr){
        Pr.setIdPrets(IdPrets);
        return pservice.savePrs(Pr);

    }
    @GetMapping(value = "/listPrets/{IdPrets}")
    public Prets  getById(@PathVariable(name = "IdPrets")long IdPrets){
        return pservice.findById(IdPrets);

    }

    @DeleteMapping (value = "/listPrets/{IdPrets}")
    public void deleteP(@PathVariable(name = "IdPrets")long IdPrets){

        pservice.deletePrs(IdPrets);
    }



}
