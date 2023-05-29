package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estadio;
import com.example.demo.repository.IEstadioRepository;

@RestController
@RequestMapping("/estadios")
@CrossOrigin
public class EstadioController {

	@Autowired
	IEstadioRepository estadioRepository;

	@GetMapping("/{id}")
	public Optional<Estadio> findByIdEstadio(@PathVariable Integer id) {
		Optional<Estadio> estadio = estadioRepository.findById(id);
		if (estadio.isPresent()) {
			return estadio;
		}
		return null;
	}
}
