package com.uasproject.oop.controller;

import com.uasproject.oop.model.Obat;
import com.uasproject.oop.service.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/obat")
public class ObatController {

    @Autowired
    private ObatService obatService;

    @GetMapping
    public String listObat(Model model) {
        model.addAttribute("obatList", obatService.getAllObat());
        return "obat-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("obat", new Obat());
        return "obat-form";
    }

    @PostMapping
    public String saveObat(@ModelAttribute Obat obat) {
        obatService.saveObat(obat);
        return "redirect:/obat";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Obat obat = obatService.getObatById(id);
        model.addAttribute("obat", obat);
        return "obat-form";
    }

    @PostMapping("/update/{id}")
    public String updateObat(@PathVariable Long id, @ModelAttribute Obat obat) {
        obat.setId(id);
        obatService.saveObat(obat);
        return "redirect:/obat";
    }

    @GetMapping("/delete/{id}")
    public String deleteObat(@PathVariable Long id) {
        obatService.deleteObatById(id);
        return "redirect:/obat";
    }
}
