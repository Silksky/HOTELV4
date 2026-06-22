package com.duoc.msservicio.controller;

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
import com.duoc.msservicio.model.Servicio;
import com.duoc.msservicio.service.ServicioService;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    //CREATE
    @PostMapping
    public ResponseEntity<Servicio> crearServicio(@RequestBody Servicio servicio) {
        try {
            Servicio nuevoServicio = servicioService.crearServicio(servicio);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoServicio);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Servicio>   > mostrarServicios() {
        try {
            List<Servicio> servicios = servicioService.mostrarServicios();
            return ResponseEntity.ok(servicios);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idServicio}")
    public ResponseEntity<Servicio> buscarServicioPorId(@PathVariable Integer idServicio) {
        try {
            Servicio servicio = servicioService.buscarServicioPorId(idServicio);
            return ResponseEntity.ok(servicio);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idServicio}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Integer idServicio) {
        try {
            servicioService.eliminarServicio(idServicio);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
