package com.duoc.mscheckin.controller;

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
import com.duoc.mscheckin.model.Checkin;
import com.duoc.mscheckin.service.CheckinService;

@RestController
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckinService checkinService;

    //CREATE
   @PostMapping
        public ResponseEntity<Checkin> crearCheckin(@RequestBody Checkin checkin) {
    try {
        Checkin nuevoCheckin = checkinService.crearCheckin(checkin);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCheckin);
        }catch (Exception e){
        e.printStackTrace();
        return ResponseEntity.badRequest().body(null);
     }
    }


    //READ
    @GetMapping
    public ResponseEntity<List<Checkin>> mostrarCheckins() {
        try {
            List<Checkin> checkins = checkinService.mostrarCheckins();
            return ResponseEntity.ok(checkins);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idCheckin}")
    public ResponseEntity<Checkin> buscarCheckinPorId(@PathVariable Integer idCheckin) {
        try {
            Checkin checkin = checkinService.buscarCheckinPorId(idCheckin);
            return ResponseEntity.ok(checkin);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //FIND BY ID HUESPED
    @GetMapping("/huesped/{idHuesped}")
    public ResponseEntity<List<Checkin>> buscarCheckinsPorHuesped(@PathVariable Integer idHuesped) {
        try {
            List<Checkin> checkins = checkinService.buscarCheckinsPorHuesped(idHuesped);
            return ResponseEntity.ok(checkins);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID HABITACION
    @GetMapping("/habitacion/{idHabitacion}")
    public ResponseEntity<List<Checkin>> buscarCheckinsPorHabitacion(@PathVariable Integer idHabitacion) {
        try {
            List<Checkin> checkins = checkinService.buscarCheckinsPorHabitacion(idHabitacion);
            return ResponseEntity.ok(checkins);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idCheckin}")
    public ResponseEntity<Void> eliminarCheckin(@PathVariable Integer idCheckin) {
        try {
            checkinService.eliminarCheckin(idCheckin);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
