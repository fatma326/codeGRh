package org.sid.projetgrh.dao;
import org.sid.projetgrh.Conges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CongesRepository  extends JpaRepository<Conges,Long> {
}
