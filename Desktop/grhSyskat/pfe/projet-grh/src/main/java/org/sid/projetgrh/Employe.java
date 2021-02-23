package org.sid.projetgrh;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.sid.projetgrh.entities.Role;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmploye;
    private long matricule;
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
    private String username;
    private String password;

    @OneToMany(mappedBy = "employe")
    private List<Displine> displines;

    @OneToMany(mappedBy = "employe")
    private List<Conges> conges;

    @OneToOne(mappedBy = "employe")
    private Licenciement licenciement;

    @OneToMany(mappedBy = "employe")
    private List<Contrats> contrats;

    @ManyToOne
    @JoinColumn(name = "id")
    private Departement departement;

    @OneToMany(mappedBy = "employe")
    private List<Pointage> pointages;

    @OneToMany(mappedBy = "employe")
    private List<AvanceSalaire> avances;

    @OneToMany(mappedBy = "employe")
    private List<Compte> compte;


    @OneToMany(mappedBy = "employe")
    private List<Prets> prets;

    @OneToMany(mappedBy = "employe")
    private List<Primefixe> primefixe;

    @OneToMany(mappedBy = "employe")
    private List<Primevariable> primevariable;

    @ManyToMany
    private List<Fonction> fonctions;

    @ManyToMany(fetch=FetchType.EAGER)
    @RestResource(exported = false)
    private Collection<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public long getMatricule() {
        return matricule;
    }

    public void setMatricule(long matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSituationFamilialle() {
        return situationFamilialle;
    }

    public void setSituationFamilialle(String situationFamilialle) {
        this.situationFamilialle = situationFamilialle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public int getNni() {
        return nni;
    }

    public void setNni(int nni) {
        this.nni = nni;
    }

    public double getSalBase() {
        return salBase;
    }

    public void setSalBase(double salBase) {
        this.salBase = salBase;
    }

    public List<Displine> getDisplines() {
        return displines;
    }

    public void setDisplines(List<Displine> displines) {
        this.displines = displines;
    }

    public List<Conges> getConges() {
        return conges;
    }

    public void setConges(List<Conges> conges) {
        this.conges = conges;
    }

    public org.sid.projetgrh.Licenciement getLicenciement() {
        return licenciement;
    }

    public void setLicenciement(org.sid.projetgrh.Licenciement licenciement) {
        this.licenciement = licenciement;
    }

    public List<Contrats> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrats> contrats) {
        this.contrats = contrats;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Pointage> getPointages() {
        return pointages;
    }

    public void setPointages(List<Pointage> pointages) {
        this.pointages = pointages;
    }

    public List<AvanceSalaire> getAvances() {
        return avances;
    }

    public void setAvances(List<AvanceSalaire> avances) {
        this.avances = avances;
    }

    public void setCompte(List<Compte> compte) {
        this.compte = compte;
    }

    public List<Compte> getCompte() {
        return compte;
    }

    public List<Prets> getPrets() {
        return prets;
    }

    public void setPrets(List<Prets> prets) {
        this.prets = prets;
    }

    public List<Primefixe> getPrimefixe() {
        return primefixe;
    }

    public void setPrimefixe(List<Primefixe> primefixe) {
        this.primefixe = primefixe;
    }

    public List<Primevariable> getPrimevariable() {
        return primevariable;
    }

    public void setPrimevariable(List<Primevariable> primevariable) {
        this.primevariable = primevariable;
    }

    public List<Fonction> getFonctions() {
        return fonctions;
    }

    public void setFonctions(List<Fonction> fonctions) {
        this.fonctions = fonctions;
    }
}
