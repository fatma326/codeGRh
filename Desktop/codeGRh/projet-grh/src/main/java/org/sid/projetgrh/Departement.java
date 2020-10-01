package org.sid.projetgrh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Departement departement_parent;  

    @ManyToOne
    @JoinColumn(name="type_departement_id")
    private Type_departement type_departement;  

    @ManyToOne
    @JoinColumn(name="profession_id")
    private Profession profession;  

    @OneToMany(mappedBy = "departement")
    private List<Employe> employes;

}
