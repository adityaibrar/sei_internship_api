package com.sei_internship.sei_internship.controller;

import com.sei_internship.sei_internship.model.Proyek;
import com.sei_internship.sei_internship.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    // POST /proyek
    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return proyekService.createProyek(proyek);
    }

    // GET /proyek
    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    // GET /proyek/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable(value = "id") int id) {
        Optional<Proyek> proyek = proyekService.getProyekById(id);
        return proyek.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /proyek/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable(value = "id") int id, @RequestBody Proyek proyekDetails) {
        Optional<Proyek> proyek = proyekService.updateProyek(id, proyekDetails);
        return proyek.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProyek(@PathVariable(value = "id") int id) {
        boolean deleted = proyekService.deleteProyek(id);
        Map<String, String> response = new HashMap<>();
        if (deleted) {
            response.put("message", "Proyek berhasil dihapus");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
