package com.duoc.mshuesped.controller;

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
import com.duoc.mshuesped.model.Huesped;
import com.duoc.mshuesped.service.HuespedService;

@RestController
@RequestMapping("/huesped")
public class HuespedController {

    @Autowired
    private HuespedService huespedService;

    //CREATE
    @PostMapping
    public ResponseEntity<Huesped> crearHuesped(@RequestBody Huesped huesped) {
        try {
            Huesped nuevoHuesped = huespedService.crearHuesped(huesped);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHuesped);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Huesped>> mostrarHuespedes() {
        try {
            List<Huesped> huespedes = huespedService.mostrarHuespedes();
            return ResponseEntity.ok(huespedes);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idHuesped}")
    public ResponseEntity<Huesped> buscarHuespedPorId(@PathVariable Integer idHuesped) {
        try {
            Huesped huesped = huespedService.buscarHuespedPorId(idHuesped);
            return ResponseEntity.ok(huesped);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idHuesped}")
    public ResponseEntity<Void> eliminarHuesped(@PathVariable Integer idHuesped) {
        try {
            huespedService.eliminarHuesped(idHuesped);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
