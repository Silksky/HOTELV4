package com.duoc.mstipohabitacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.duoc.mstipohabitacion.model.TipoHabitacion;
import com.duoc.mstipohabitacion.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionService {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    //CREATE
    public TipoHabitacion crearTipoHabitacion(TipoHabitacion tipoHabitacion) {
        if (tipoHabitacionRepository.existsByNombre(tipoHabitacion.getNombre())) {
            throw new RuntimeException("Tipo habitacion con nombre " + tipoHabitacion.getNombre() + " ya existe");
        }
        return tipoHabitacionRepository.save(tipoHabitacion);
    }

    //READ
    public List<TipoHabitacion> mostrarTiposHabitacion() {
        if (tipoHabitacionRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay tipos de habitacion registrados");
        }
        return tipoHabitacionRepository.findAll();
    }

    //FIND BY ID
    public TipoHabitacion buscarTipoHabitacionPorId(Integer idTipoHabitacion) {
        return tipoHabitacionRepository.findById(idTipoHabitacion)
                .orElseThrow(() -> new RuntimeException("Tipo habitacion con id " + idTipoHabitacion + " no encontrado"));
    }

    //DELETE
    public void eliminarTipoHabitacion(Integer idTipoHabitacion) {
        if (!tipoHabitacionRepository.existsById(idTipoHabitacion)) {
            throw new RuntimeException("Tipo habitacion con id " + idTipoHabitacion + " no encontrado");
        }
        tipoHabitacionRepository.deleteById(idTipoHabitacion);
    }
}
