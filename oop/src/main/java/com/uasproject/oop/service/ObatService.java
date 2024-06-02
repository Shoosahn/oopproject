package com.uasproject.oop.service;

import com.uasproject.oop.model.Obat;
import com.uasproject.oop.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObatService {

    @Autowired
    private ObatRepository obatRepository;

    public List<Obat> getAllObat() {
        return obatRepository.findAll();
    }

    public Obat getObatById(Long id) {
        Optional<Obat> optionalObat = obatRepository.findById(id);
        return optionalObat.orElse(null);  // return null if Obat not found
    }

    public Obat saveObat(Obat obat) {
        return obatRepository.save(obat);
    }

    public void deleteObatById(Long id) {
        obatRepository.deleteById(id);
    }
}
