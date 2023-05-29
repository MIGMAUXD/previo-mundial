package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Partido{
	@Id
	@SequenceGenerator(name="partido_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "partido_id_seq")
	private Integer id;
	private Date fecha;
	@ManyToOne
	@JoinColumn(name="estadio_id")
	private Estadio estadio;
	@JsonIgnore
	@OneToMany(mappedBy = "partido")
	private List<Resultado>resultados;
}
