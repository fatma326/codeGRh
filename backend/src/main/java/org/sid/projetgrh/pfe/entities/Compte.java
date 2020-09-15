package org.sid.projetgrh.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Compte implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCmpte;
    private double numerCmpte;
    private String nomBanque;


    @ManyToOne
    private Employe employe;






}
