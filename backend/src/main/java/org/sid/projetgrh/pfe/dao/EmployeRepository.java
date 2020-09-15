package org.sid.projetgrh.pfe.dao;


import org.sid.projetgrh.pfe.entities.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface EmployeRepository extends JpaRepository <Employe,Long>{
    @RestResource(path = "/byNom")
    public  List<Employe> findByNomContains(@Param("mc") String nom);

    @RestResource(path = "/byNomPage")
    public Page<Employe> findByNomContains(@Param("mc") String nom, Pageable pageable);

    public List<Employe> findByNomContainsAndPrenomContains(String nom, String prenom);

    public List<Employe> findByNomContainsAndPrenomContainsAndNniEquals(String nom, String prenom, int nni);

}
