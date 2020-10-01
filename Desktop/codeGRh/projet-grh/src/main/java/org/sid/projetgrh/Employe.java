package org.sid.projetgrh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employe implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idEmploye;
  private String nom;
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
  private double salBase;

  @OneToMany(mappedBy = "employe")
  private List<Displine> displines;

  @OneToMany(mappedBy = "employe")
  private List<Conges> conges;

  @OneToOne(mappedBy = "employe")
  private licenciement licenciement;

  @OneToMany(mappedBy = "employe")
  private List<Contrats> contrats;

  @ManyToOne
  @JoinColumn(name="departement_id")
  private Departement departement;

  @OneToMany(mappedBy = "employe")
  private List<Pointage> pointages;

  @OneToMany(mappedBy = "employe")
  private List<AvanceSalaire> avances;

  @ManyToOne
  private Compte compte;

  @OneToMany(mappedBy = "employe")
  private List<Prets> prets;

  @OneToMany(mappedBy = "employe")
  private List<Primefixe> primefixe ;

  @OneToMany(mappedBy = "employe")
  private List<Primevariable> primevariable;

  @ManyToMany
  private List<Fonction> fonctions;



}
