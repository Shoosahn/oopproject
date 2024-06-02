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

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    // other getters and setters
}
