package com.duoc.mscheckin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.duoc.mscheckin.model.Checkin;

@Repository
public interface CheckinRepository extends JpaRepository<Checkin, Integer> {
    public boolean existsByIdHabitacion(Integer idHabitacion);
    public List<Checkin> findByIdHuesped(Integer idHuesped);
    public List<Checkin> findByIdHabitacion(Integer idHabitacion);
}
