package org.sid.projetgrh.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Employe implements Serializable
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)


  private long idEmploye;
  private  String nom;
  private String prenom;
  private String adresse;
  private int contact;
  private int etat;
  private String titre;
  private String situationFamilialle;
  private String email;
  private String genre;
  private int numeroCompte;
  private int nni;




}
