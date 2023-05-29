package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Partido;
import com.example.demo.entity.Resultado;
import com.example.demo.repository.IPartidoRepository;

@RestController
@RequestMapping("/partidos")
@CrossOrigin
public class PartidoController {

	@Autowired
	IPartidoRepository partidoRepository;

	@GetMapping
	public List<Partido> listAllPartidos() {
		return partidoRepository.findAll();
	}

	@GetMapping("/{id}/resultados")
	public List<Resultado> listPartidoResultado(@PathVariable Integer id) {
		Optional<Partido> partido = partidoRepository.findById(id);
		if (partido.isPresent()) {
			return partido.get().getResultados();
		}
		return null;
	}
}
