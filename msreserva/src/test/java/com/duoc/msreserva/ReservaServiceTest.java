package com.duoc.msreserva;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import com.duoc.msreserva.client.HabitacionClient;
import com.duoc.msreserva.client.HuespedClient;
import com.duoc.msreserva.client.TipoHabitacionClient;
import com.duoc.msreserva.model.Reserva;
import com.duoc.msreserva.repository.ReservaRepository;
import com.duoc.msreserva.service.ReservaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private HuespedClient huespedClient;

    @Mock
    private HabitacionClient habitacionClient;

    @Mock
    private TipoHabitacionClient tipoHabitacionClient;

    @InjectMocks
    private ReservaService reservaService;

    @Test
    void debeLanzarExcepcionSiHabitacionYaTieneReserva() {

        Reserva reserva = new Reserva();
        reserva.setIdHabitacion(1);
        reserva.setIdHuesped(1);
        reserva.setIdTipoHabitacion(1);

        when(reservaRepository.existsByIdHabitacion(1))
                .thenReturn(true);

        assertThrows(RuntimeException.class, () -> {
                reservaService.crearReserva(reserva);
        });

        verify(reservaRepository).existsByIdHabitacion(1);
        verify(reservaRepository, never()).save(any(Reserva.class));
        }


    @Test
    void debeCrearReservaCorrectamente() {

        Reserva reserva = new Reserva();

        reserva.setIdHabitacion(1);
        reserva.setIdHuesped(1);
        reserva.setIdTipoHabitacion(1);
        reserva.setCantidadPersonas(2);
        reserva.setMontoTotal(150000.0);
        reserva.setServicios("Wifi");
        reserva.setFechaEntrada(LocalDateTime.now());
        reserva.setFechaSalida(LocalDateTime.now().plusDays(2));
        reserva.setFechaReserva(LocalDateTime.now());

        when(reservaRepository.existsByIdHabitacion(1))
                .thenReturn(false);

        when(reservaRepository.save(any(Reserva.class)))
                .thenReturn(reserva);

        Reserva resultado = reservaService.crearReserva(reserva);

        assertNotNull(resultado);

        verify(habitacionClient)
                .buscarHabitacionPorId(1);

        verify(huespedClient)
                .buscarHuespedPorId(1);

        verify(tipoHabitacionClient)
                .buscarTipoHabitacionPorId(1);

        verify(reservaRepository)
                .save(reserva);
        }
}