package org.sid.projetgrh.dao;
import org.sid.projetgrh.licenciement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface licenciementRepository  extends JpaRepository<licenciement,Long> {
}
