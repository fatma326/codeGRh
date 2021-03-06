package org.sid.projetgrh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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

    private Timestamp heures_entree;
    private Timestamp heures_sortie;
    private String  absence;
    private String type_absence;
    private int heursSup;
    private int tauxHorraire;
    private int HeureTotal;

  //  private  int weekend;
   // private int ferier;

    @ManyToOne
    private Employe employe;

}
