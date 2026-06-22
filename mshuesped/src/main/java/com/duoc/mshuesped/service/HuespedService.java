package com.duoc.mshuesped.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.duoc.mshuesped.model.Huesped;
import com.duoc.mshuesped.repository.HuespedRepository;

@Service
public class HuespedService {

    @Autowired
    private HuespedRepository huespedRepository;

    //CREATE
    public Huesped crearHuesped(Huesped huesped) {
        if (huespedRepository.existsByEmail(huesped.getEmail())) {
            throw new RuntimeException("Huesped con email " + huesped.getEmail() + " ya existe");
        }
        if (huespedRepository.existsByRut(huesped.getRut())) {
            throw new RuntimeException("Huesped con rut " + huesped.getRut() + " ya existe");
        }
        return huespedRepository.save(huesped);
    }

    //READ
    public List<Huesped> mostrarHuespedes() {
        if (huespedRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay huespedes registrados");
        }
        return huespedRepository.findAll();
    }

    //FIND BY ID
    public Huesped buscarHuespedPorId(Integer idHuesped) {
        return huespedRepository.findById(idHuesped)
                .orElseThrow(() -> new RuntimeException("Huesped con id " + idHuesped + " no encontrado"));
    }

    //DELETE
    public void eliminarHuesped(Integer idHuesped) {
        if (!huespedRepository.existsById(idHuesped)) {
            throw new RuntimeException("Huesped con id " + idHuesped + " no encontrado");
        }
        huespedRepository.deleteById(idHuesped);
    }
}
