package com.uasproject.oop.service;

import com.uasproject.oop.model.Obat;
import com.uasproject.oop.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ObatService {

    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> getAllObat() {
        return obatRepository.findAll();
    }

    public Obat getObatById(Long id) {
        return obatRepository.findById(id).orElse(null);
    }

    public Obat saveObat(Obat obat) {
        return obatRepository.save(obat);
    }

    public void deleteObat(Long id) {
        obatRepository.deleteById(id);
    }

    @Transactional
    public void performTransactionExample(Obat obat1, Obat obat2) {
        obatRepository.save(obat1);
        obatRepository.save(obat2);
    }
}
