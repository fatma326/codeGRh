package org.sid.projetgrh.dao;
import org.sid.projetgrh.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface derpartementRepository extends JpaRepository<Departement,Long> {
}
