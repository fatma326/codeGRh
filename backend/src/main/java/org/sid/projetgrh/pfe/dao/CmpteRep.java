package org.sid.projetgrh.pfe.dao;

import org.sid.projetgrh.pfe.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmpteRep extends JpaRepository<Compte,Long> {
}
