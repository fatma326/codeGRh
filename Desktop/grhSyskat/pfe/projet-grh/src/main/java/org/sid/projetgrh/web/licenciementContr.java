package org.sid.projetgrh.web;

import org.sid.projetgrh.Displine;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Licenciement;
import org.sid.projetgrh.service.licenciementRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class licenciementContr {
    @Autowired
    licenciementRestService licenciementRestService;

    @GetMapping(value = "/licenciementList")
    public List<Licenciement> licenciementList(){
        return licenciementRestService.licenciementList().stream().map(licenciement -> {
            return Licenciement.builder()
                    .id(licenciement.getId())
                    .date(licenciement.getDate())
                    .nature_sanction(licenciement.getNature_sanction())
                    .employe(licenciement.getEmploye() != null ? Employe.builder().idEmploye(licenciement.getEmploye().getIdEmploye()).nom(licenciement.getEmploye().getNom()).build():null)
                    .build();
        }).collect(Collectors.toList());

    }



    @PostMapping(value = "/licenciementList")
    public Licenciement saveL(@RequestBody Licenciement Lo) {
        return licenciementRestService.save(Lo);
    }

    @PutMapping(value = "/licenciementList/{id}")
    public Licenciement updateL(@PathVariable(name = "id") long id, @RequestBody Licenciement Lo) {
        Lo.setId(id);
        return licenciementRestService.save(Lo);
    }

    @GetMapping(value = "/licenciementList/{id}")
    public Licenciement getByIdL(@PathVariable(name = "id") long id) {
        return licenciementRestService.findById(id);
    }


    @DeleteMapping(value = "/licenciementList/{id}")
    public void deleteL(@PathVariable(name = "id") long id) {
        licenciementRestService.delete(id);
    }


}
