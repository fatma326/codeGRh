package org.sid.projetgrh;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
public class Displine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDispline;
    private String typeDispline;
    private String nomSuperviseur;
    private Date date;
    private String Description;
    private String Demande_explication;

    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;

}
