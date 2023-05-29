package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Resultado implements Serializable{

	@Id
	@SequenceGenerator(name="resultado_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "resultado_id_seq")
	private Integer id;
	@Column(name="partido_id")
	private Integer partido;
	@Column(name="seleccion_id")
	private Integer seleccionId;
	private Integer goles;
	private Integer amarillas;
	private Integer rojas;
}
