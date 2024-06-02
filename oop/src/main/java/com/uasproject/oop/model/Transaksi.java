package com.uasproject.oop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id")
    private Pelanggan pelanggan;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaksiDetail> transaksiDetails = new ArrayList<>();

    private Double total;

    // Getters and Setters

    public void addTransaksiDetail(TransaksiDetail detail) {
        transaksiDetails.add(detail);
        detail.setTransaksi(this);
    }

    // other getters and setters
}
