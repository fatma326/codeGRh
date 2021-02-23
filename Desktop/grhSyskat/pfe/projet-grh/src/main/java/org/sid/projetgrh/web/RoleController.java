package org.sid.projetgrh.web;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.RoleRepository;
import org.sid.projetgrh.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping(value = "/roles")
    public List<Role> rolesList() {
        return roleRepository.findAll();
    }









}
