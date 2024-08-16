package com.sei_internship.sei_internship.controller;

import com.sei_internship.sei_internship.model.Lokasi;
import com.sei_internship.sei_internship.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable int id) {
        Optional<Lokasi> lokasi = lokasiService.findById(id);
        return lokasi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.save(lokasi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable int id, @RequestBody Lokasi lokasiDetails) {
        Optional<Lokasi> lokasi = lokasiService.findById(id);
        if (lokasi.isPresent()) {
            Lokasi updatedLokasi = lokasi.get();
            updatedLokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
            updatedLokasi.setNegara(lokasiDetails.getNegara());
            updatedLokasi.setProvinsi(lokasiDetails.getProvinsi());
            updatedLokasi.setKota(lokasiDetails.getKota());
            updatedLokasi.setCreatedAt(lokasiDetails.getCreatedAt());
            return ResponseEntity.ok(lokasiService.save(updatedLokasi));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteLokasi(@PathVariable int id) {
//        if (lokasiService.findById(id).isPresent()) {
//            lokasiService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLokasi(@PathVariable int id) {
        boolean deleted = lokasiService.deleteById(id);
        Map<String, String> response = new HashMap<>();
        if (deleted) {
            response.put("message", "Lokasi berhasil dihapus");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}