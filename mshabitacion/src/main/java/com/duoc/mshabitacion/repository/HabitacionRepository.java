package com.duoc.mshabitacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.mshabitacion.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
    public boolean existsByNumeroHabitacion(Integer numeroHabitacion);
}
