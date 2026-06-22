package com.duoc.msreserva.config;

import com.duoc.msreserva.model.Reserva;
import com.duoc.msreserva.repository.ReservaRepository;


import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarReserva(ReservaRepository reservaRepository) {
        return args -> {

            if (reservaRepository.count() == 0) {

                Reserva reserva1 = new Reserva();
                reserva1.setFechaEntrada(LocalDateTime.parse("2026-06-01T14:00:00"));
                reserva1.setFechaSalida(LocalDateTime.parse("2026-10-01T18:00:00"));
                reserva1.setIdHuesped(1);
                reserva1.setIdHabitacion(1);
                reserva1.setIdTipoHabitacion(1);
                reserva1.setCantidadPersonas(1);
                reserva1.setServicios("Ninguno");
                reserva1.setMontoTotal(400.00);
                reserva1.setFechaReserva(LocalDateTime.parse("2026-05-01T10:00:00"));

                Reserva reserva2 = new Reserva();
                reserva2.setFechaEntrada(LocalDateTime.parse("2026-07-01T14:00:00"));
                reserva2.setFechaSalida(LocalDateTime.parse("2026-11-01T18:00:00"));
                reserva2.setIdHuesped(2);
                reserva2.setIdHabitacion(2);
                reserva2.setIdTipoHabitacion(2);
                reserva2.setCantidadPersonas(2);
                reserva2.setServicios("Acceso a spa y jacuzzi");
                reserva2.setMontoTotal(425.00);
                reserva2.setFechaReserva(LocalDateTime.parse("2026-06-01T10:00:00"));

                reservaRepository.save(reserva1);
                reservaRepository.save(reserva2);
            }
        };
    }
}