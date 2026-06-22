package com.duoc.mshabitacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.duoc.mshabitacion.model.Habitacion;
import com.duoc.mshabitacion.repository.HabitacionRepository;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    //CREATE
    public Habitacion crearHabitacion(Habitacion habitacion) {
        if (habitacionRepository.existsByNumeroHabitacion(habitacion.getNumeroHabitacion())) {
            throw new RuntimeException("Habitacion con numero " + habitacion.getNumeroHabitacion() + " ya existe");
        }
        return habitacionRepository.save(habitacion);
    }

    //READ
    public List<Habitacion> mostrarHabitaciones() {
        if (habitacionRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay habitaciones registradas");
        }
        return habitacionRepository.findAll();
    }

    //FIND BY ID
    public Habitacion buscarHabitacionPorId(Integer idHabitacion) {
        return habitacionRepository.findById(idHabitacion)
                .orElseThrow(() -> new RuntimeException("Habitacion con id " + idHabitacion + " no encontrada"));
    }

    //DELETE
    public void eliminarHabitacion(Integer idHabitacion) {
        if (!habitacionRepository.existsById(idHabitacion)) {
            throw new RuntimeException("Habitacion con id " + idHabitacion + " no encontrada");
        }
        habitacionRepository.deleteById(idHabitacion);
    }
}
