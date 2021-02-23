package org.sid.projetgrh.dao;

import org.sid.projetgrh.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CmpteRep extends JpaRepository<Compte,Long> {
}
