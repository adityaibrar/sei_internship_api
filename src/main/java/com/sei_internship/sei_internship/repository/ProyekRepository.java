package com.sei_internship.sei_internship.repository;

import com.sei_internship.sei_internship.model.Proyek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Integer> {
}