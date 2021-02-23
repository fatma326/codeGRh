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
public class Primevariable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdprimeV;

    private String nomPrimeV;
    private int Code_Prime;
    private float valeur_prime;
    private Date date_primeVr;
    private int pourcentageSalaire;


    @ManyToOne
    private Employe employe;

}
