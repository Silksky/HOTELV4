package com.duoc.mscheckout.config;

import com.duoc.mscheckout.model.Checkout;
import com.duoc.mscheckout.repository.CheckoutRepository;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarCheckin(CheckoutRepository checkoutRepository) {
        return args -> {

            if (checkoutRepository.count() == 0) {

                Checkout checkout1 = new Checkout();
                checkout1.setFechaSalida(LocalDateTime.parse("2026-06-10T12:00:00"));
                checkout1.setIdHuesped(1);
                checkout1.setIdHabitacion(1);
                checkout1.setObservaciones("Salida anticipada");
                checkout1.setMontoPagado(150.00);
                

                checkoutRepository.save(checkout1);

            }
        };
    }
}