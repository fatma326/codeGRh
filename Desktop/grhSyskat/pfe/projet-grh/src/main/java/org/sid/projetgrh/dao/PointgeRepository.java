package org.sid.projetgrh.dao;

import org.sid.projetgrh.Employe;
import org.sid.projetgrh.Pointage;
import org.sid.projetgrh.Primefixe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface PointgeRepository extends JpaRepository<Pointage, Long> {

    List<Pointage> findAllByEmploye(Employe e);
    //List<Pointage> findAllByEmployeIdAndDate_Pointage(Long empId, Date date);
    @Query(value = "select * from pointage   where YEAR(heures_entree) =?1 and MONTH(heures_entree) = ?2 and employe_id_employe = ?3" ,nativeQuery = true)
    List<Pointage> getEmployePointages(Integer year, Integer month, Long id);

}

