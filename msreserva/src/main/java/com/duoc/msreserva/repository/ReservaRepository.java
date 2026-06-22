package com.duoc.msreserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.msreserva.model.Reserva;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    public boolean existsByIdHabitacion(Integer idHabitacion);
    public List<Reserva> findByIdHuesped(Integer idHuesped);
}
