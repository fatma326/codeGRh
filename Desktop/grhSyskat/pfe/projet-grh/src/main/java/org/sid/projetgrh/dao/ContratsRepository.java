package org.sid.projetgrh.dao;
import org.sid.projetgrh.Contrats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ContratsRepository extends JpaRepository<Contrats,Long> {
    Contrats findFirstByEmploye_IdEmploye(Long id);
}
