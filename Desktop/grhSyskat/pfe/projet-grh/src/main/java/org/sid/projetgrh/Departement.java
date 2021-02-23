package org.sid.projetgrh;

import lombok.*;

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
@Builder
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Departement departement_parent;  

    @ManyToOne
    @JoinColumn(name="idType")
    private Type_departement TypeDepartement;

    @ManyToOne
    @JoinColumn(name="idProfession")
    private Profession profession;  

    @OneToMany(mappedBy = "departement")
    private List<Employe> employes;

}
