package org.sid.projetgrh.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPrets;
    private double valeur_totale;
    private double retenu_mensuel;
    private Date date_affectatin;

    @ManyToOne
    private Employe employe;







}
