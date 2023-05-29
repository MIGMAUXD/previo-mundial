package com.example.demo.entity;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Seleccion implements Serializable{
 
	@Id
	@SequenceGenerator(name="seleccion_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seleccion_id_seq")
	private Integer id;
	private String nombre;
	@ManyToOne
	@JoinColumn(name="continente_id")
	private Continente continente;
	private String grupo;
}
