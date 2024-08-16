package com.sei_internship.sei_internship.service;

import com.sei_internship.sei_internship.model.Proyek;
import com.sei_internship.sei_internship.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    // Menambahkan Proyek baru
    public Proyek createProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    // Mendapatkan semua data Proyek
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    // Mendapatkan Proyek berdasarkan ID
    public Optional<Proyek> getProyekById(int id) {
        return proyekRepository.findById(id);
    }

    // Mengupdate data Proyek
    public Optional<Proyek> updateProyek(int id, Proyek proyekDetails) {
        return proyekRepository.findById(id).map(proyek -> {
            proyek.setNamaProyek(proyekDetails.getNamaProyek());
            proyek.setClient(proyekDetails.getClient());
            proyek.setTglMulai(proyekDetails.getTglMulai());
            proyek.setTglSelesai(proyekDetails.getTglSelesai());
            proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
            proyek.setKeterangan(proyekDetails.getKeterangan());
            proyek.setLokasiSet(proyekDetails.getLokasiSet());
            return proyekRepository.save(proyek);
        });
    }

    // Menghapus Proyek berdasarkan ID
    public boolean deleteProyek(int id) {
        return proyekRepository.findById(id).map(proyek -> {
            proyekRepository.delete(proyek);
            return true;
        }).orElse(false);
    }
}
