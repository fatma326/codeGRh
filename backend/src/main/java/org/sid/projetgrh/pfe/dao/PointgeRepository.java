package org.sid.projetgrh.pfe.dao;

import org.sid.projetgrh.pfe.entities.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface PointgeRepository extends JpaRepository <Pointage, Long> {
}
