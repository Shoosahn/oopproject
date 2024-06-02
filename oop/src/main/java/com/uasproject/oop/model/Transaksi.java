package com.uasproject.oop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date tanggal;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id")
    private Pelanggan pelanggan;

    private Double total;

    @OneToMany(mappedBy = "transaksi")
    private List<TransaksiDetail> transaksiDetails;

    // Getters and Setters
    // Constructor
}
