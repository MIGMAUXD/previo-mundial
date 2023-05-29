package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Seleccion;

public interface ISeleccionRepository extends JpaRepository<Seleccion, Integer>{

	public List<Seleccion>findByGrupo(String grupo);
	
}
