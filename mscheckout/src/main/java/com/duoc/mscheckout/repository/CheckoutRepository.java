package com.duoc.mscheckout.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duoc.mscheckout.model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    public boolean existsByIdHabitacion(Integer idHabitacion);
    public List<Checkout> findByIdHuesped(Integer idHuesped);
    public List<Checkout> findByIdHabitacion(Integer idHabitacion);
}
