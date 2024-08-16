package com.sei_internship.sei_internship.service;

import com.sei_internship.sei_internship.model.Lokasi;
import com.sei_internship.sei_internship.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> findById(int id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi save(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public Boolean deleteById(int id) {
        return lokasiRepository.findById(id).map(lokasi -> {
            lokasiRepository.delete(lokasi);
            return true;
        }).orElse(false);
    }
}