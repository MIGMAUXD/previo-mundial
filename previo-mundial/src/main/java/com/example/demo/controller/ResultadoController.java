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

import com.example.demo.entity.Resultado;
import com.example.demo.repository.IResultadoRepository;


@Controller
@RequestMapping("/resultados")
@CrossOrigin
public class ResultadoController {

    @Autowired
    IResultadoRepository resultadoRepository;

    @GetMapping
    public String listAllResultados(Model model) {
        List<Resultado> resultados = resultadoRepository.findAll();
        model.addAttribute("resultados", resultados);
        return "resultados/list";
    }

    @PostMapping
    public String saveResultado(@ModelAttribute Resultado resultado) {
        resultadoRepository.save(resultado);
        return "redirect:/resultados";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Resultado> resultado = resultadoRepository.findById(id);
        if (resultado.isPresent()) {
            model.addAttribute("resultado", resultado.get());
            return "resultados/form";
        }
        return "redirect:/resultados";
    }

    @PostMapping("/edit/{id}")
    public String updateResultado(@PathVariable Integer id, @ModelAttribute Resultado resultado) {
        Optional<Resultado> resultadoCurrent = resultadoRepository.findById(id);
        if (resultadoCurrent.isPresent()) {
            Resultado resultadoReturn = resultadoCurrent.get();
            resultadoReturn.setPartido(resultado.getPartido());
            resultadoReturn.setSeleccionId(resultado.getSeleccionId());
            resultadoReturn.setGoles(resultado.getGoles());
            resultadoReturn.setRojas(resultado.getRojas());
            resultadoReturn.setAmarillas(resultado.getAmarillas());
            resultadoRepository.save(resultadoReturn);
        }
        return "redirect:/resultados";
    }
}

