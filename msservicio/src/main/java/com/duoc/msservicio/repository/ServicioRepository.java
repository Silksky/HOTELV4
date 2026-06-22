package com.duoc.msservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.msservicio.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    public boolean existsByNombre(String nombre);
}
