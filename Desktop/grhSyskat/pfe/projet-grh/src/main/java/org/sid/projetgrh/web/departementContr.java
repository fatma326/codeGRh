package org.sid.projetgrh.web;
import org.sid.projetgrh.Conges;
import org.sid.projetgrh.Departement;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.service.DepartementRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class departementContr {

    @Autowired
    DepartementRestService departementRestService;




    @GetMapping(value = "/depList")
    public List<Departement>depList (){
        return departementRestService.depList().stream().map(departement -> {
            return Departement.builder()
                    .id(departement.getId())
                    .nom(departement.getNom())
                    .profession(departement.getProfession())
                    .TypeDepartement(departement.getTypeDepartement())
                    .departement_parent(departement.getDepartement_parent() != null ? Departement.builder().id(departement.getDepartement_parent().getId()).nom(departement.getDepartement_parent().getNom()).build() : null)
                    .employes(departement.getEmployes() != null ? departement.getEmployes().stream().map(employe ->{
                        return Employe.builder().idEmploye(employe.getIdEmploye()).nom(employe.getNom()).build();
                    } ).collect(Collectors.toList()) : null)
                    .build();



// .employe(conges.getEmploye() != null ? Employe.builder().idEmploye(conges.getEmploye().getIdEmploye()).nom(conges.getEmploye().getNom()).build() : null)
//
        }).collect(Collectors.toList());

    }

    @PostMapping(value = "/depList")
    public Departement save(@RequestBody Departement Do){
        return departementRestService.save(Do);
    }


    @PutMapping(value = "/depList/{id}")
    public Departement updateD(@PathVariable(name = "id")long id, @RequestBody Departement Do){
        Do.setId(id);
        return departementRestService.save(Do);
    }

    @GetMapping(value = "/depList/{id}")
    public Departement getById(@PathVariable(name = "id")long id){
        return departementRestService.findById(id);
    }


    @DeleteMapping(value = "/depList/{id}")
    public void delete(@PathVariable(name = "id")long id){
        departementRestService.delete(id);
    }
}


