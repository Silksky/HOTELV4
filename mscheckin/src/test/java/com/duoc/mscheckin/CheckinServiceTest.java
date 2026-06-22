package com.duoc.mscheckin;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import com.duoc.mscheckin.client.HabitacionClient;
import com.duoc.mscheckin.client.HuespedClient;
import com.duoc.mscheckin.model.Checkin;
import com.duoc.mscheckin.repository.CheckinRepository;
import com.duoc.mscheckin.service.CheckinService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CheckinServiceTest {

    @Mock
    private CheckinRepository checkinRepository;

    @Mock
    private HuespedClient huespedClient;

    @Mock
    private HabitacionClient habitacionClient;

    @InjectMocks
    private CheckinService checkinService;

    @Test
    void debeLanzarExcepcionSiHabitacionYaTieneReserva() {

        Checkin checkin = new Checkin();
        checkin.setIdHabitacion(1);
        checkin.setIdHuesped(1);

        when(checkinRepository.existsByIdHabitacion(1))
                .thenReturn(true);

        assertThrows(RuntimeException.class, () -> {
                checkinService.crearCheckin(checkin);
        });

        verify(checkinRepository).existsByIdHabitacion(1);
        verify(checkinRepository, never()).save(any(Checkin.class));
        }


        @Test
        void debeCrearCheckinCorrectamente() {

        Checkin checkin = new Checkin();

        checkin.setIdHabitacion(1);
        checkin.setIdHuesped(1);
        checkin.setFechaIngreso(LocalDateTime.now());
        checkin.setFechaSalida(LocalDateTime.now().plusDays(2));

        when(checkinRepository.existsByIdHabitacion(1))
                .thenReturn(false);

        when(checkinRepository.save(any(Checkin.class)))
                .thenReturn(checkin);

        Checkin resultado = checkinService.crearCheckin(checkin);

        assertNotNull(resultado);

        verify(habitacionClient)
                .buscarHabitacionPorId(1);

        verify(huespedClient)
                .buscarHuespedPorId(1);

        verify(checkinRepository)
                .save(checkin);
        }
}