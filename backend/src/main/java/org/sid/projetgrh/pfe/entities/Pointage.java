package org.sid.projetgrh.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pointage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPointage;

    private Date Date_Pointage;
    private  int heures_entree;
    private int heures_sortie;
    private String  absence;
    private String type_absence;
    private int weekend;
    private int ferier;

    @ManyToOne
    private Employe employe;



}
