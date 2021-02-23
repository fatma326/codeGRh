package org.sid.projetgrh.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sid.projetgrh.Employe;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String role;
}
