package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Continente;
import com.example.demo.repository.IContinenteRepository;

@Controller
@RequestMapping("/continentes")
@CrossOrigin
public class ContinenteController {

    @Autowired
    IContinenteRepository continenteRepository;

    @GetMapping
    public String listAllContinente(Model model) {
        List<Continente> continentes = continenteRepository.findAll();
        model.addAttribute("continentes", continentes);
        return "continentes/list";
    }

    @GetMapping("/{id}")
    public String findByIdContinente(@PathVariable Integer id, Model model) {
        Optional<Continente> continente = continenteRepository.findById(id);
        if (continente.isPresent()) {
            model.addAttribute("continente", continente.get());
            return "continentes/detail";
        }
        return "redirect:/continentes";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("continente", new Continente());
        return "continentes/form";
    }

    @PostMapping("/create")
    public String saveContinente(@ModelAttribute Continente continente) {
        continenteRepository.save(continente);
        return "redirect:/continentes";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Continente> continente = continenteRepository.findById(id);
        if (continente.isPresent()) {
            model.addAttribute("continente", continente.get());
            return "continentes/form";
        }
        return "redirect:/continentes";
    }

    @PostMapping("/edit/{id}")
    public String updateContinente(@PathVariable Integer id, @ModelAttribute Continente continente) {
        Optional<Continente> continenteCurrent = continenteRepository.findById(id);
        if (continenteCurrent.isPresent()) {
            Continente continenteReturn = continenteCurrent.get();
            continenteReturn.setNombre(continente.getNombre());
            continenteRepository.save(continenteReturn);
        }
        return "redirect:/continentes";
    }

    @GetMapping("/delete/{id}")
    public String deleteContinente(@PathVariable Integer id) {
        Optional<Continente> continente = continenteRepository.findById(id);
        if (continente.isPresent()) {
            continenteRepository.deleteById(id);
        }
        return "redirect:/continentes";
    }
}

