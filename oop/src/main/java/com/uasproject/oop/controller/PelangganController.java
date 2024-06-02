package com.uasproject.oop.controller;

import com.uasproject.oop.model.Pelanggan;
import com.uasproject.oop.service.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    @GetMapping
    public String listPelanggan(Model model) {
        model.addAttribute("pelangganList", pelangganService.getAllPelanggan());
        return "pelanggan-list";
    }

    @GetMapping("/new")
    public String createPelangganForm(Model model) {
        model.addAttribute("pelanggan", new Pelanggan());
        return "pelanggan-form";
    }

    @PostMapping
    public String savePelanggan(@ModelAttribute("pelanggan") Pelanggan pelanggan) {
        pelangganService.savePelanggan(pelanggan);
        return "redirect:/pelanggan";
    }

    @GetMapping("/edit/{id}")
    public String editPelangganForm(@PathVariable Long id, Model model) {
        model.addAttribute("pelanggan", pelangganService.getPelangganById(id));
        return "pelanggan-form";
    }

    @PostMapping("/update/{id}")
    public String updatePelanggan(@PathVariable Long id, @ModelAttribute("pelanggan") Pelanggan pelanggan) {
        pelangganService.savePelanggan(pelanggan);
        return "redirect:/pelanggan";
    }

    @GetMapping("/delete/{id}")
    public String deletePelanggan(@PathVariable Long id) {
        pelangganService.deletePelanggan(id);
        return "redirect:/pelanggan";
    }
}
