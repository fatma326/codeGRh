package org.sid.projetgrh.dao;

import org.sid.projetgrh.AvanceSalaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvanceRep extends JpaRepository<AvanceSalaire, Long> {
}
