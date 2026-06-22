package com.duoc.mscheckout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.duoc.mscheckout.model.Checkout;
import com.duoc.mscheckout.repository.CheckoutRepository;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    //CREATE
    public Checkout crearCheckout(Checkout checkout) {
        if (checkout.getIdHabitacion() == null || checkout.getIdHuesped() == null) {
            throw new RuntimeException("idHabitacion e idHuesped son requeridos");
        }
        if (checkoutRepository.existsByIdHabitacion(checkout.getIdHabitacion())) {
            throw new RuntimeException("Ya existe un checkout para la habitacion " + checkout.getIdHabitacion());
        }
        return checkoutRepository.save(checkout);
    }

    //READ
    public List<Checkout> mostrarCheckouts() {
        if (checkoutRepository.findAll().isEmpty()) {
            throw new RuntimeException("No hay checkouts registrados");
        }
        return checkoutRepository.findAll();
    }

    //FIND BY ID
    public Checkout buscarCheckoutPorId(Integer idCheckout) {
        return checkoutRepository.findById(idCheckout)
                .orElseThrow(() -> new RuntimeException("Checkout con id " + idCheckout + " no encontrado"));
    }

    //FIND BY ID CLIENTE
    public List<Checkout> buscarCheckoutsPorHuesped(Integer idCliente) {
        List<Checkout> checkouts = checkoutRepository.findByIdHuesped(idCliente);
        if (checkouts.isEmpty()) {
            throw new RuntimeException("No hay checkouts para el cliente con id " + idCliente);
        }
        return checkouts;
    }

    //FIND BY ID HABITACION
    public List<Checkout> buscarCheckoutsPorHabitacion(Integer numeroHabitacion) {
        List<Checkout> checkouts = checkoutRepository.findByIdHabitacion(numeroHabitacion);
        if (checkouts.isEmpty()) {
            throw new RuntimeException("No hay checkouts para la habitacion con numero " + numeroHabitacion);
        }
        return checkouts;
    }

    //DELETE
    public void eliminarCheckout(Integer idCheckout) {
        if (!checkoutRepository.existsById(idCheckout)) {
            throw new RuntimeException("Checkout con id " + idCheckout + " no encontrado");
        }
        checkoutRepository.deleteById(idCheckout);
    }
}
