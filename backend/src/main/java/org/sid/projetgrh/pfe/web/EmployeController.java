package org.sid.projetgrh.pfe.web;

import org.sid.projetgrh.pfe.entities.Employe;
import org.sid.projetgrh.pfe.service.EmployeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeController {

    @Autowired
    EmployeRestService employeRestService;
    @GetMapping(value = "/listemployes")
    public List<Employe> listEmployes(){
        return employeRestService.listEmployes();

    }
}
