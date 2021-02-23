package org.sid.projetgrh.service;

import org.sid.projetgrh.Contrats;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.ContratsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContratRestService {
    @Autowired
    ContratsRepository ContratsRepository;

    @GetMapping(value = "/ContratList")
    public List<Contrats> ContratList(){
        List<Contrats> contrats = ContratsRepository.findAll().stream().map(contrat -> {
            return Contrats.builder()
                    .idContrats(contrat.getIdContrats())
                    .employe( getEmp(contrat.getEmploye())
                    )
                    .typeCon(contrat.getTypeCon())
                    .date_emabauche(contrat.getDate_emabauche())
                    .mode_reglement(contrat.getMode_reglement())
                    .salaire_base(contrat.getSalaire_base())
                    .build();
        }).collect(Collectors.toList());
        return contrats;


    }

    @GetMapping(value = "/ContratList/{idContrats}")
    public Contrats ContratList(@PathVariable(name = "idContrats")long idContrats){
        return  ContratsRepository.findById(idContrats).get();

    }

    @PutMapping(value = "/ContratList/{idContrats}")
    public Contrats update(@PathVariable(name = "idContrats")long idContrats,@RequestBody Contrats c ){
        return ContratsRepository.save(c);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping (value = "/ContratList")
    public Contrats save(@RequestBody Contrats c){
         ContratsRepository.save(c);
        return null;
    }


    @DeleteMapping (value =  "/ContratList/{idContrats}")
    public void delete(@PathVariable(name = "idContrats")long idContrats){

        ContratsRepository.deleteById(idContrats);

    }





    private Employe getEmp(Employe employe){
        if (employe ==null ) return null;
       return Employe.builder()
                .idEmploye(employe.getIdEmploye())
                .numeroCompte(employe.getNumeroCompte())
                .etat(employe.getEtat())
                .matricule(employe.getMatricule())
                .nni(employe.getNni())
                .email(employe.getEmail())
                .adresse(employe.getAdresse())
                .nom(employe.getNom())
                .prenom(employe.getPrenom())
                .build();

    }

}
