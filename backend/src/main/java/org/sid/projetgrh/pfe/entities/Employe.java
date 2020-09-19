package org.sid.projetgrh.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.projetgrh.pfe.entities.Pointage;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @ToString
public class Employe implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


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
  private double numeroCompte;
  private double nni;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Pointage> pointages;

  @OneToMany
  private List<AvanceSalaire> avances;

  @ManyToOne
  private Compte compte;







}
