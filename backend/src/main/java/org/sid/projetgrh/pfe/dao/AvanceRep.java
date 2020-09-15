package org.sid.projetgrh.pfe.dao;

import org.sid.projetgrh.pfe.entities.AvanceSalaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvanceRep extends JpaRepository <AvanceSalaire, Long> {
}
