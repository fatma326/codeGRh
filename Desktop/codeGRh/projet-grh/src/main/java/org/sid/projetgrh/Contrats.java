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
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Contrats implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrats;
    private Date date_emabauche;
    private String mode_reglement;
    private int salaire_base;

    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;

    @OneToOne
    @JoinColumn(name = "type_contrat_id")
    private Contrats contrat;

}
