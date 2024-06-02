package com.uasproject.oop.controller;

import com.uasproject.oop.model.Transaksi;
import com.uasproject.oop.model.TransaksiDetail;
import com.uasproject.oop.service.ObatService;
import com.uasproject.oop.service.PelangganService;
import com.uasproject.oop.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaksi")
public class TransaksiController {

    @Autowired
    private TransaksiService transaksiService;

    @Autowired
    private PelangganService pelangganService;

    @Autowired
    private ObatService obatService;

    @GetMapping
    public String listTransaksi(Model model) {
        model.addAttribute("transaksiList", transaksiService.getAllTransaksi());
        return "transaksi-list";
    }

    @GetMapping("/new")
    public String createTransaksiForm(Model model) {
        Transaksi transaksi = new Transaksi();
        model.addAttribute("transaksi", transaksi);
        model.addAttribute("pelangganList", pelangganService.getAllPelanggan());
        model.addAttribute("obatList", obatService.getAllObat());
        return "transaksi-form";
    }

    @PostMapping
    public String saveTransaksi(@ModelAttribute("transaksi") Transaksi transaksi, @RequestParam("obatIds") List<Long> obatIds, @RequestParam("jumlah") List<Integer> jumlah) {
        double total = 0;
        for (int i = 0; i < obatIds.size(); i++) {
            Long obatId = obatIds.get(i);
            Integer qty = jumlah.get(i);
            double hargaSatuan = obatService.getObatById(obatId).getHarga();
            double subtotal = hargaSatuan * qty;
            total += subtotal;

            TransaksiDetail detail = new TransaksiDetail();
            detail.setObat(obatService.getObatById(obatId));
            detail.setJumlah(qty);
            detail.setHargaSatuan(hargaSatuan);
            detail.setTotal(subtotal);
            transaksi.getTransaksiDetails().add(detail);
        }

        transaksi.setTotal(total);
        transaksiService.saveTransaksi(transaksi);

        return "redirect:/transaksi";
    }

    @GetMapping("/edit/{id}")
    public String editTransaksiForm(@PathVariable Long id, Model model) {
        Transaksi transaksi = transaksiService.getTransaksiById(id);
        model.addAttribute("transaksi", transaksi);
        model.addAttribute("pelangganList", pelangganService.getAllPelanggan());
        model.addAttribute("obatList", obatService.getAllObat());
        return "transaksi-form";
    }

    @PostMapping("/update/{id}")
    public String updateTransaksi(@PathVariable Long id, @ModelAttribute("transaksi") Transaksi transaksi, @RequestParam("obatIds") List<Long> obatIds, @RequestParam("jumlah") List<Integer> jumlah) {
        double total = 0;
        transaksi.getTransaksiDetails().clear();
        for (int i = 0; i < obatIds.size(); i++) {
            Long obatId = obatIds.get(i);
            Integer qty = jumlah.get(i);
            double hargaSatuan = obatService.getObatById(obatId).getHarga();
            double subtotal =