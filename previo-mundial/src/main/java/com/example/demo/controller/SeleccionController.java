package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Seleccion;
import com.example.demo.repository.ISeleccionRepository;

@Controller
@RequestMapping("/selecciones")
public class SeleccionController {

    @Autowired
    private ISeleccionRepository seleccionRepository;

    @GetMapping
    public String listAllSeleccion(Model model) {
        List<Seleccion> selecciones = seleccionRepository.findAll();
        model.addAttribute("selecciones", selecciones);
        return "selecciones/list";
    }

    @GetMapping("/{id}")
    public String findByIdSeleccion(@PathVariable Integer id, Model model) {
        Optional<Seleccion> seleccion = seleccionRepository.findById(id);
        if (seleccion.isPresent()) {
            model.addAttribute("seleccion", seleccion.get());
            return "selecciones/detail";
        }
        return "error";
    }

    @GetMapping("/grupo/{grupo}")
    public String findSeleccionByGrupo(@PathVariable String grupo, Model model) {
        List<Seleccion> selecciones = seleccionRepository.findByGrupo(grupo);
        model.addAttribute("selecciones", selecciones);
        return "selecciones/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("seleccion", new Seleccion());
        return "selecciones/form";
    }

    @PostMapping("/create")
    public String saveSeleccion(@ModelAttribute Seleccion seleccion) {
        seleccionRepository.save(seleccion);
        return "redirect:/selecciones";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Optional<Seleccion> seleccion = seleccionRepository.findById(id);
        if (seleccion.isPresent()) {
            model.addAttribute("seleccion", seleccion.get());
            return "selecciones/form";
        }
        return "error";
    }

    @PostMapping("/edit/{id}")
    public String updateSeleccion(@PathVariable Integer id, @ModelAttribute Seleccion seleccion) {
        Optional<Seleccion> seleccionCurrent = seleccionRepository.findById(id);
        if (seleccionCurrent.isPresent()) {
            Seleccion seleccionReturn = seleccionCurrent.get();
            seleccionReturn.setNombre(seleccion.getNombre());
            seleccionReturn.setContinente(seleccion.getContinente());
            seleccionReturn.setGrupo(seleccion.getGrupo());
            seleccionRepository.save(seleccionReturn);
        }
        return "redirect:/selecciones";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeleccion(@PathVariable Integer id) {
        Optional<Seleccion> seleccion = seleccionRepository.findById(id);
        if (seleccion.isPresent()) {
            seleccionRepository.deleteById(id);
        }
        return "redirect:/selecciones";
    }
}
