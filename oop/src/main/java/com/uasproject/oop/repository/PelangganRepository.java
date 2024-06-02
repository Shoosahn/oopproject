package com.uasproject.oop.repository;

import com.uasproject.oop.model.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {
}
