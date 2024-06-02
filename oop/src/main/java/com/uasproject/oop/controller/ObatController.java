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

    @GetMapping("/new")
    public String createObatForm(Model model) {
        model.addAttribute("obat", new Obat());
        return "obat-form";
    }

    @PostMapping
    public String saveObat(@ModelAttribute("obat") Obat obat) {
        obatService.saveObat(obat);
        return "redirect:/obat";
    }

    @GetMapping("/edit/{id}")
    public String editObatForm(@PathVariable Long id, Model model) {
        model.addAttribute("obat", obatService.getObatById(id));
        return "obat-form";
    }

    @PostMapping("/update/{id}")
    public String updateObat(@PathVariable Long id, @ModelAttribute("obat") Obat obat) {
        obatService.saveObat(obat);
        return "redirect:/obat";
    }

    @GetMapping("/delete/{id}")
    public String deleteObat(@PathVariable Long id) {
        obatService.deleteObat(id);
        return "redirect:/obat";
    }
}
