package com.duoc.mshuesped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.mshuesped.model.Huesped;

@Repository
public interface HuespedRepository extends JpaRepository<Huesped, Integer> {
    public boolean existsByEmail(String email);
    public boolean existsByRut(String rut);
}
