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
public class Primefixe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdprimeF;

    private String nomPrime;
    private String type_Prime;
    private int Code_Prime;
    private float exonoree;
    private float valeur_prime;
    private Date date_primefx;

    @ManyToOne
    private Employe employe;

}
