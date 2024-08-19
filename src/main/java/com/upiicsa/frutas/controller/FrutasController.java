package com.upiicsa.frutas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.upiicsa.frutas.entities.Fruta;
import com.upiicsa.frutas.repositories.FrutasRepositorio;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
@RequestMapping("/frutas")
public class FrutasController {

    @Autowired
    private FrutasRepositorio repo;

    // -----------------------------Guardar---------------------------------------------------------
    @GetMapping("/formulario")
    public String showForm(Model model) {
        model.addAttribute("fruta", new Fruta());
        return "formulario";
    }

    @PostMapping("/formulario")
    public String saveProducto(@ModelAttribute("fruta") Fruta fruta) {
        repo.save(fruta);
        return "redirect:/frutas/listar";
    }

    // -----------------------------Mostrar---------------------------------------------------------
    @GetMapping("/listar")
    public String listarFrutas(Model model) {
        List<Fruta> listaFrutas = repo.findAll();
        model.addAttribute("listaFrutas", listaFrutas);
        return "listar";
    }

    // -----------------------------Eliminar---------------------------------------------------------
    @GetMapping("/eliminar/{id}")
    public String eliminarFruta(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/frutas/listar";
    }

    // -----------------------------Editar---------------------------------------------------------
    @GetMapping("/editar/{id}")
    public String formularioModificarFruta(@PathVariable Long id, Model model) {
        Fruta fruta = repo.findById(id).orElse(null);
        if (fruta == null) {
            return "redirect:/frutas/listar";
        }
        model.addAttribute("fruta", fruta);
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String actualizarFruta(@PathVariable Long id, @ModelAttribute("fruta") Fruta fruta) {
        Fruta frutaExistente = repo.findById(id).orElse(null);
        if (frutaExistente != null) {
            frutaExistente.setNombre(fruta.getNombre());
            frutaExistente.setCantidad(fruta.getCantidad());
            frutaExistente.setPrecio(fruta.getPrecio());
            repo.save(frutaExistente);
        }
        return "redirect:/frutas/listar";
    }

}
