package com.duoc.msservicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.duoc.msservicio.model.Servicio;
import com.duoc.msservicio.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    //CREATE
    public Servicio crearServicio(Servicio servicio) {
        if (servicioRepository.existsByNombre(servicio.getNombre())) {
            throw new RuntimeException("Servicio con nombre " + servicio.getNombre() + " ya existe");
        }
        return servicioRepository.save(servicio);
    }

    //READ
    public List<Servicio> mostrarServicios() {
        if (servicioRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay servicios registrados");
        }
        return servicioRepository.findAll();
    }

    //FIND BY ID
    public Servicio buscarServicioPorId(Integer idServicio) {
        return servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio con id " + idServicio + " no encontrado"));
    }

    //DELETE
    public void eliminarServicio(Integer idServicio) {
        if (!servicioRepository.existsById(idServicio)) {
            throw new RuntimeException("Servicio con id " + idServicio + " no encontrado");
        }
        servicioRepository.deleteById(idServicio);
    }
}
