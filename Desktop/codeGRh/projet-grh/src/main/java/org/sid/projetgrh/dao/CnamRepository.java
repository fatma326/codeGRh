package org.sid.projetgrh.dao;

import org.sid.projetgrh.CNAM;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CnamRepository extends JpaRepository<CNAM,Long> {
}
