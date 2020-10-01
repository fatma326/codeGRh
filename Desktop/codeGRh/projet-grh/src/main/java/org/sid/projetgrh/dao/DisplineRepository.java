package org.sid.projetgrh.dao;

import org.sid.projetgrh.Displine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DisplineRepository extends JpaRepository<Displine,Long> {
}
