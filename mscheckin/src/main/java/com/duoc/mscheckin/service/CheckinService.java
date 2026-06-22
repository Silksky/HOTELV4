package com.duoc.mscheckin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.duoc.mscheckin.client.HuespedClient;
import com.duoc.mscheckin.client.HabitacionClient;
import com.duoc.mscheckin.model.Checkin;
import com.duoc.mscheckin.repository.CheckinRepository;

@Service
public class CheckinService {

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired 
    private HuespedClient huespedClient;

    @Autowired
    private HabitacionClient habitacionClient;


    


    //CREATE
    public Checkin crearCheckin(Checkin checkin) {

    System.out.println("PASO 1");

    if (checkin.getIdHabitacion() == null || checkin.getIdHuesped() == null) {
        throw new RuntimeException("idHabitacion e idHuesped son requeridos");
    }

    System.out.println("PASO 2");

    if (checkinRepository.existsByIdHabitacion(checkin.getIdHabitacion())) {
        throw new RuntimeException("Ya existe un checkin para la habitacion " + checkin.getIdHabitacion());
    }

    System.out.println("PASO 3");

    // 👇 VALIDACIÓN CORRECTA SIN DTO
    try {
        habitacionClient.buscarHabitacionPorId(checkin.getIdHabitacion());
    } catch (feign.FeignException.NotFound e) {
        throw new RuntimeException("La habitación no existe");
    }

    try {
        huespedClient.buscarHuespedPorId(checkin.getIdHuesped());
    } catch (feign.FeignException.NotFound e) {
        throw new RuntimeException("El huésped no existe");
    }

    System.out.println("PASO 4");

    return checkinRepository.save(checkin);
}




    

    //READ
    public List<Checkin> mostrarCheckins() {
        if (checkinRepository.findAll(). isEmpty()) {
            throw new RuntimeException("No hay checkins registrados");
        }
        return checkinRepository.findAll();
    }

    //FIND BY ID
    public Checkin buscarCheckinPorId(Integer idCheckin) {
        return checkinRepository.findById(idCheckin)
                .orElseThrow(() -> new RuntimeException("Checkin con id " + idCheckin + " no encontrado"));
    }

    //FIND BY ID HUESPED
    public List<Checkin> buscarCheckinsPorHuesped(Integer idHuesped) {
        List<Checkin> checkins = checkinRepository.findByIdHuesped(idHuesped);
        if (checkins.isEmpty()) {
            throw new RuntimeException("No hay checkins para el huesped con id " + idHuesped);
        }
        return checkins;
    }

    //FIND BY ID HABITACION
    public List<Checkin> buscarCheckinsPorHabitacion(Integer idHabitacion) {
        List<Checkin> checkins = checkinRepository.findByIdHabitacion(idHabitacion);
        if (checkins.isEmpty()) {
            throw new RuntimeException("No hay checkins para la habitacion con id " + idHabitacion);
        }
        return checkins;
    }

    //DELETE
    public void eliminarCheckin(Integer idCheckin) {
        if (!checkinRepository.existsById(idCheckin)) {
            throw new RuntimeException("Checkin con id " + idCheckin + " no encontrado");
        }
        checkinRepository.deleteById(idCheckin);
    }
}
