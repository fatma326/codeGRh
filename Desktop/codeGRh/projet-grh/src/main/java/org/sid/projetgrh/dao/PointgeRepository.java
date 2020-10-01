package org.sid.projetgrh.dao;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.Primefixe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface PointgeRepository extends JpaRepository<Pointage, Long> {
    @Query("SELECT p from Pointage p where p.employe=?1")
    List<Pointage> getPointageByEmploye(Employe e);
}

