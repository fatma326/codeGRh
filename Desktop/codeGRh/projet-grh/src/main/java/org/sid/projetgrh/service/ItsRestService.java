package org.sid.projetgrh.service;


import org.sid.projetgrh.ITS;
import org.sid.projetgrh.dao.ItsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItsRestService {
    @Autowired
    ItsRepository  ItsRepository;

    @GetMapping(value = "/ItsList")
    public List<ITS> itsList(){
        return ItsRepository.findAll();

    }

    @GetMapping(value = "/ItsList/{idIts}")
    public ITS itsList (@PathVariable(name = "idIts")long idIts){
        return  ItsRepository.findById(idIts).get();

    }

    @PutMapping(value = "/ItsList/{idIts}")
    public ITS update(@PathVariable(name = "idIts")long idIts,@RequestBody ITS i){
        return ItsRepository.save(i);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/ItsList")
    public ITS save(@RequestBody ITS i){
        return ItsRepository.save(i);
    }

    @DeleteMapping (value = "/ItsList/{idIts}")
    public void delete(@PathVariable(name = "idIts")long idIts){

        ItsRepository.deleteById(idIts);

    }




}
