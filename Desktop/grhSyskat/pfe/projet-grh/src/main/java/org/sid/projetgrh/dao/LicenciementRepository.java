package org.sid.projetgrh.dao;
import org.sid.projetgrh.Licenciement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LicenciementRepository  extends JpaRepository<Licenciement,Long> {
    Licenciement findFirstByEmploye_IdEmploye(Long id);
}
