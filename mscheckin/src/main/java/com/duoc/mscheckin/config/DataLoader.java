package com.duoc.mscheckin.config;

import com.duoc.mscheckin.model.Checkin;
import com.duoc.mscheckin.repository.CheckinRepository;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarCheckin(CheckinRepository checkinRepository) {
        return args -> {

            if (checkinRepository.count() == 0) {

                Checkin checkin1 = new Checkin();
                checkin1.setFechaIngreso(LocalDateTime.parse("2026-06-08T14:00:00"));
                checkin1.setFechaSalida(LocalDateTime.parse("2026-06-10T12:00:00"));
                checkin1.setIdHuesped(1);
                checkin1.setIdHabitacion(1);
                


                checkinRepository.save(checkin1);
            }
        };
    }
}