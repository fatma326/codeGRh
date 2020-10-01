package org.sid.projetgrh.service;


import org.sid.projetgrh.Displine;
import org.sid.projetgrh.dao.DisplineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DisplineRestService {
    @Autowired
    DisplineRepository DisplineRepository ;

    @GetMapping(value = "/DisplineList")
    public List<Displine> displineList(){
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





}
