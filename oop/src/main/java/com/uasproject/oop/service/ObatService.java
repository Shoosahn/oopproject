package com.uasproject.oop.service;

import com.uasproject.oop.model.Obat;
import com.uasproject.oop.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatService {
    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> findAll() {
        return obatRepository.findAll();
    }

    public Obat save(Obat obat) {
        return obatRepository.save(obat);
    }

    public void deleteById(Long id) {
        obatRepository.deleteById(id);
    }
}
