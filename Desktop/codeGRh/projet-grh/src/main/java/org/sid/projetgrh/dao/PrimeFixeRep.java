package org.sid.projetgrh.dao;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Primefixe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrimeFixeRep extends JpaRepository<Primefixe,Long> {
    @Query("SELECT pf from Primefixe pf where pf.employe=?1")
    List<Primefixe> getPrimefixeByEmploye(Employe e);
}
