package org.sid.projetgrh.dao;


import org.sid.projetgrh.Type_contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface typeContrat_Repository  extends JpaRepository<Type_contrat,Long> {
}
