package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Partido;
import com.example.demo.repository.IPartidoRepository;

@Controller
@RequestMapping("/partidos")
@CrossOrigin
public class PartidoController {

    @Autowired
    IPartidoRepository partidoRepository;

    @GetMapping
    public String listAllPartidos(Model model) {
        List<Partido> partidos = partidoRepository.findAll();
        model.addAttribute("partidos", partidos);
        return "partidos/list";
    }

    @GetMapping("/{id}/resultados")
    public String listPartidoResultado(@PathVariable Integer id, Model model) {
        Optional<Partido> partido = partidoRepository.findById(id);
        if (partido.isPresent()) {
            model.addAttribute("resultados", partido.get().getResultados());
            return "partidos/resultados";
        }
        return "redirect:/partidos";
    }
}

