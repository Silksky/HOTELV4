package com.duoc.mscheckout.controller;

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
import com.duoc.mscheckout.model.Checkout;
import com.duoc.mscheckout.service.CheckoutService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    //CREATE
    @PostMapping
    public ResponseEntity<Checkout> crearCheckout(@RequestBody Checkout checkout) {
        try {
            Checkout nuevoCheckout = checkoutService.crearCheckout(checkout);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCheckout);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //READ ALL
    @GetMapping
    public ResponseEntity<List<Checkout>> mostrarCheckouts() {
        try {
            List<Checkout> checkouts = checkoutService.mostrarCheckouts();
            return ResponseEntity.ok(checkouts);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID
    @GetMapping("/{idCheckout}")
    public ResponseEntity<Checkout> buscarCheckoutPorId(@PathVariable Integer idCheckout) {
        try {
            Checkout checkout = checkoutService.buscarCheckoutPorId(idCheckout);
            return ResponseEntity.ok(checkout);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //FIND BY ID HUESPED
    @GetMapping("/huesped/{idHuesped}")
    public ResponseEntity<List<Checkout>> buscarCheckoutsPorHuesped(@PathVariable Integer idHuesped) {
        try {
            List<Checkout> checkouts = checkoutService.buscarCheckoutsPorHuesped(idHuesped);
            return ResponseEntity.ok(checkouts);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //FIND BY ID HABITACION
    @GetMapping("/habitacion/{idHabitacion}")
    public ResponseEntity<List<Checkout>> buscarCheckoutsPorHabitacion(@PathVariable Integer idHabitacion) {
        try {
            List<Checkout> checkouts = checkoutService.buscarCheckoutsPorHabitacion(idHabitacion);
            return ResponseEntity.ok(checkouts);
        } catch (RuntimeException e) {
            return ResponseEntity.noContent().build();
        }
    }

    //DELETE
    @DeleteMapping("/{idCheckout}")
    public ResponseEntity<Void> eliminarCheckout(@PathVariable Integer idCheckout) {
        try {
            checkoutService.eliminarCheckout(idCheckout);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
