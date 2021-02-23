package org.sid.projetgrh;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Compte implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCmpte;
    private double numerCmpte;
    private String nomBanque;


    @ManyToOne
    @JoinColumn(name="employe_id")
    private Employe employe;





}
