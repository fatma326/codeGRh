package org.sid.projetgrh.dao;

import org.sid.projetgrh.Anciennete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AncienneteRepository extends JpaRepository<Anciennete,Long> {
}
