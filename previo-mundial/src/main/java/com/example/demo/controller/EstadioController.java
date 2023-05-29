package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estadio;
import com.example.demo.repository.IEstadioRepository;

@Controller
@RequestMapping("/estadios")
@CrossOrigin
public class EstadioController {

    @Autowired
    IEstadioRepository estadioRepository;

    @GetMapping("/{id}")
    public String findByIdEstadio(@PathVariable Integer id, Model model) {
        Optional<Estadio> estadio = estadioRepository.findById(id);
        if (estadio.isPresent()) {
            model.addAttribute("estadio", estadio.get());
            return "estadios/detail";
        }
        return "redirect:/estadios";
    }
}

