package org.sid.projetgrh.dao;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Primefixe;
import org.sid.projetgrh.Primevariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrimeVarRep extends JpaRepository<Primevariable,Long> {
    @Query("SELECT pf from Primevariable pf where pf.employe=?1")
    List<Primevariable> getPrimevariableByEmploye(Employe e);
}
