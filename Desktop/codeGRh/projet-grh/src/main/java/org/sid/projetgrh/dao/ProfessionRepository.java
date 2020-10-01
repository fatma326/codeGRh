package org.sid.projetgrh.dao;

import org.sid.projetgrh.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessionRepository extends JpaRepository<Profession,Long> {
}
