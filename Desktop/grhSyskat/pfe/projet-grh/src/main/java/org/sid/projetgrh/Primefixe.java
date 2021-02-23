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
public class Primefixe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IdprimeF;

    private String nomPrime;
    private int Code_Prime;
    private float valeur_prime;
    private Date date_primefx;

    @ManyToOne
    private Employe employe;

}
