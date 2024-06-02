package com.uasproject.oop.repository;

import com.uasproject.oop.model.Obat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObatRepository extends JpaRepository<Obat, Long> {
}
