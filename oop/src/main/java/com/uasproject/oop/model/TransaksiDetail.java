package com.uasproject.oop.model;

import javax.persistence.*;

@Entity
public class TransaksiDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaksi_id")
    private Transaksi transaksi;

    @ManyToOne
    @JoinColumn(name = "obat_id")
    private Obat obat;

    private Integer jumlah;
    private Double hargaSatuan;
    private Double subtotal;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Obat getObat() {
        return obat;
    }

    public void setObat(Obat obat) {
        this.obat = obat;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(Double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}
