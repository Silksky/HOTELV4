package com.duoc.mstipohabitacion.controller;

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
import com.duoc.mstipohabitacion.model.TipoHabitacion;
import com.duoc.mstipohabitacion.service.TipoHabitacionService;

@RestController
@RequestMapping("/tipohabitacion")
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    //CREATE
    @PostMapping
    public ResponseEntity<TipoHabitacion> crearTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion) {
        try {
            TipoHabitacion nuevoTipo = tipoHabitacionService.crearTipoHabitacion(tipoHabitacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<TipoHabitacion>> mostrarTiposHabitacion() {
        try {
            List<TipoHabitacion> tipos = tipoHabitacionService.mostrarTiposHabitacion();
            return ResponseEntity.ok(tipos);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
    }
    }

    //FIND BY ID
    @GetMapping("/{idTipoHabitacion}")
    public ResponseEntity<TipoHabitacion> buscarTipoHabitacionPorId(@PathVariable Integer idTipoHabitacion) {
        try {
            TipoHabitacion tipo = tipoHabitacionService.buscarTipoHabitacionPorId(idTipoHabitacion);
            return ResponseEntity.ok(tipo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idTipoHabitacion}")
    public ResponseEntity<Void> eliminarTipoHabitacion(@PathVariable Integer idTipoHabitacion) {
        try {
            tipoHabitacionService.eliminarTipoHabitacion(idTipoHabitacion);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
