package org.sid.projetgrh.dao;


import org.sid.projetgrh.Type_departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypeDepartement_Repository extends JpaRepository<Type_departement,Long> {
}
