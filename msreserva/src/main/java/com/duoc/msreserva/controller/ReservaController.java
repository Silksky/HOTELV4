package com.duoc.msreserva.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.duoc.msreserva.model.Reserva;
import com.duoc.msreserva.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    //CREATE
   @PostMapping
        public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
    try {
        Reserva nuevaReserva = reservaService.crearReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
        }catch (Exception e){
        e.printStackTrace();
        return ResponseEntity.badRequest().body(null);
     }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Reserva>> mostrarReservas() {
        try {
            List<Reserva> reservas = reservaService.mostrarReservas();
            return ResponseEntity.ok(reservas);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idReserva}")
    public ResponseEntity<Reserva> buscarReservaPorId(@PathVariable Integer idReserva) {
        try {
            Reserva reserva = reservaService.buscarReservaPorId(idReserva);
            return ResponseEntity.ok(reserva);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //FIND BY HUESPED ID
    @GetMapping("/huesped/{idHuesped}")
    public ResponseEntity<List<Reserva>> buscarReservasPorHuesped(@PathVariable Integer idHuesped) {
        try {
            List<Reserva> reservas = reservaService.buscarReservasPorHuesped(idHuesped);
            return ResponseEntity.ok(reservas);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idReserva}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Integer idReserva) {
        try {
            reservaService.eliminarReserva(idReserva);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
