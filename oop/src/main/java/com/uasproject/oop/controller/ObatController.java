package com.uasproject.oop.controller;

import com.uasproject.oop.model.Obat;
import com.uasproject.oop.service.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/obat")
public class ObatController {
    @Autowired
    private ObatService obatService;

    @GetMapping
    public String listObat(Model model) {
        List<Obat> obats = obatService.findAll();
        model.addAttribute("obats", obats);
        return "obat/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("obat", new Obat());
        return "obat/form";
    }

    @PostMapping
    public String saveObat(@ModelAttribute Obat obat) {
        obatService.save(obat);
        return "redirect:/obat";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Obat obat = obatService.findById(id);
        model.addAttribute("obat", obat);
        return "obat/form";
    }

    @PostMapping("/update/{id}")
    public String updateObat(@PathVariable Long id, @ModelAttribute Obat obat) {
        obat.setId(id);
        obatService.save(obat);
        return "redirect:/obat";
    }

    @GetMapping("/delete/{id}")
    public String deleteObat(@PathVariable Long id) {
        obatService.deleteById(id);
        return "redirect:/obat";
    }
}
