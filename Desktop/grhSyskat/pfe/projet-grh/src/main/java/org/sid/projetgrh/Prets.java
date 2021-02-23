package org.sid.projetgrh;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Prets implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdPrets;
    private double montant ;
    private double retenu_mensuel;
    private Date date_affectation;
    private int nbre_mois;



    @ManyToOne
    private Employe employe;







}
