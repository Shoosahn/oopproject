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

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaksiDetail> transaksiDetails;

    // Constructors
    public Transaksi() {
    }

    public Transaksi(Date tanggal, Pelanggan pelanggan, Double total) {
        this.tanggal = tanggal;
        this.pelanggan = pelanggan;
        this.total = total;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<TransaksiDetail> getTransaksiDetails() {
        return transaksiDetails;
    }

    public void setTransaksiDetails(List<TransaksiDetail> transaksiDetails) {
        this.transaksiDetails = transaksiDetails;
    }
}
