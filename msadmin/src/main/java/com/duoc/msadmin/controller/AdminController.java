package com.duoc.msadmin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.msadmin.model.Admin;
import com.duoc.msadmin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //CREATE
    @PostMapping
    public ResponseEntity<Admin> crearAdmin(@RequestBody Admin admin) {
        try {
            Admin nuevoAdmin = adminService.crearAdmin(admin);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdmin);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Admin>> mostrarAdministradores() {
        try {
            List<Admin> admins = adminService.mostrarAdministradores();
            return ResponseEntity.ok(admins);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idAdmin}")
    public ResponseEntity<Admin> buscarAdminPorId(@PathVariable Integer idAdmin) {
        try {
            Admin admin = adminService.buscarAdminPorId(idAdmin);
            return ResponseEntity.ok(admin);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idAdmin}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable Integer idAdmin) {
        try {
            adminService.eliminarAdmin(idAdmin);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
