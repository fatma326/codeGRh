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
public class Conges implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConges;
    private int duree;
    private Date dateDebut;
    private  String type;

    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;
}
