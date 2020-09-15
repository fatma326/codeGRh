package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.AvanceSalaire;
import org.sid.projetgrh.pfe.entities.Compte;
import org.sid.projetgrh.pfe.service.AvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AvanceContr {

    @Autowired
    private AvanceService avanceService;


    @GetMapping(value = "/ListAvance")
    public List<AvanceSalaire> ListAvance(){
        return avanceService.ListAvance();
    }

    @PostMapping(value = "/ListAvance")
    public AvanceSalaire saveA(@RequestBody AvanceSalaire Av){
        return avanceService.saveAv(Av);
    }

    @PutMapping(value = "/ListAvance/{idAvance}")
    public AvanceSalaire updateA(@PathVariable(name = "idAvance")long idAvance, @RequestBody AvanceSalaire Av){
        Av.setIdAvance(idAvance);
        return avanceService.saveAv(Av);
    }

    @GetMapping(value = "/ListAvance/{idAvance}")
    public AvanceSalaire getByIdA(@PathVariable(name = "idAvance")long idAvance){
        return avanceService.findByIdAv(idAvance);
    }

    @DeleteMapping(value = "/ListAvance/{idAvance}")
    public void deleteA(@PathVariable(name = "idAvance")long idAvance){
        avanceService.deleteAv(idAvance);
    }
}
