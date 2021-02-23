package org.sid.projetgrh;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AvanceSalaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAvance;

    private double valeur;
    private Date date_affectation;
    private String type;
    private int mois;

    @ManyToOne
    private Employe employe;



}
