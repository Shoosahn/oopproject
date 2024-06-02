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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public List<TransaksiDetail> getTransaksiDetails() {
        return transaksiDetails;
    }

    public void setTransaksiDetails(List<TransaksiDetail> transaksiDetails) {
        this.transaksiDetails = transaksiDetails;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void addTransaksiDetail(TransaksiDetail detail) {
        transaksiDetails.add(detail);
        detail.setTransaksi(this);
    }
}
