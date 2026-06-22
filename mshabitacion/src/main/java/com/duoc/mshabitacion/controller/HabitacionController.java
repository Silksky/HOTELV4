package com.duoc.mshabitacion.controller;

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
import com.duoc.mshabitacion.model.Habitacion;
import com.duoc.mshabitacion.service.HabitacionService;

@RestController
@RequestMapping("/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    //CREATE
    @PostMapping
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion habitacion) {
        try {
            Habitacion nuevaHabitacion = habitacionService.crearHabitacion(habitacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaHabitacion);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Habitacion>> mostrarHabitaciones() {
        try {
            List<Habitacion> habitaciones = habitacionService.mostrarHabitaciones();
            return ResponseEntity.ok(habitaciones);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idHabitacion}")
    public ResponseEntity<Habitacion> buscarHabitacionPorId(@PathVariable Integer idHabitacion) {
        try {
            Habitacion habitacion = habitacionService.buscarHabitacionPorId(idHabitacion);
            return ResponseEntity.ok(habitacion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idHabitacion}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Integer idHabitacion) {
        try {
            habitacionService.eliminarHabitacion(idHabitacion);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
