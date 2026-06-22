package com.duoc.msadmin.repository;

import com.duoc.msadmin.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByNombre(String nombre);
}
