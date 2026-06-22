package com.duoc.msreserva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.duoc.msreserva.client.TipoHabitacionClient;
import com.duoc.msreserva.client.HabitacionClient;
import com.duoc.msreserva.client.HuespedClient;
import com.duoc.msreserva.model.Reserva;
import com.duoc.msreserva.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired 
    private HuespedClient huespedClient;

    @Autowired
    private TipoHabitacionClient tipoHabitacionClient;

    @Autowired
    private HabitacionClient habitacionClient;

    //CREATE
    public Reserva crearReserva(Reserva reserva) {

    System.out.println("PASO 1");
    if (reserva.getIdHabitacion() == null || reserva.getIdHuesped() == null) {
        throw new RuntimeException("idHabitacion e idHuesped son requeridos");
    }
    System.out.println("PASO 2");
    if (reservaRepository.existsByIdHabitacion(reserva.getIdHabitacion())) {
        throw new RuntimeException("Ya existe una reserva para la habitacion " + reserva.getIdHabitacion());
    }
    System.out.println("PASO 3");
        //VALIDAR HABITACION
    try {
        habitacionClient.buscarHabitacionPorId(reserva.getIdHabitacion());
    } catch (feign.FeignException.NotFound e) {
        throw new RuntimeException("La habitación no existe");
    }
        //VALIDAR HUESPED
    try {
        huespedClient.buscarHuespedPorId(reserva.getIdHuesped());
    } catch (feign.FeignException.NotFound e) {
        throw new RuntimeException("El huésped no existe");
    }
        //VALIDAR TIPO HABITACION
    try {
        tipoHabitacionClient.buscarTipoHabitacionPorId(reserva.getIdTipoHabitacion());
    } catch (feign.FeignException.NotFound e) {
        throw new RuntimeException("El tipo de habitación no existe");
    }
    System.out.println("PASO 4");
    return reservaRepository.save(reserva);
}




    //READ
    public List<Reserva> mostrarReservas() {
        if (reservaRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay reservas registradas");
        }
        return reservaRepository.findAll();
    }

    //FIND BY ID
    public Reserva buscarReservaPorId(Integer idReserva) {
        return reservaRepository.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva con id " + idReserva + " no encontrada"));
    }

    //FIND BY ID HUESPED
    public List<Reserva> buscarReservasPorHuesped(Integer idHuesped) {
        List<Reserva> reservas = reservaRepository.findByIdHuesped(idHuesped);
        if (reservas.isEmpty()) {
            throw new RuntimeException("No hay reservas para el huesped con id " + idHuesped);
        }
        return reservas;
    }

    //DELETE
    public void eliminarReserva(Integer idReserva) {
        if (!reservaRepository.existsById(idReserva)) {
            throw new RuntimeException("Reserva con id " + idReserva + " no encontrada");
        }
        reservaRepository.deleteById(idReserva);
    }
}
