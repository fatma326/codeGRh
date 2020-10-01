package org.sid.projetgrh.dao;


import org.sid.projetgrh.CNSS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CnssRepository  extends JpaRepository<CNSS,Long> {
}
