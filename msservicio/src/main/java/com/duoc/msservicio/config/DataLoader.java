package com.duoc.msservicio.config;

import com.duoc.msservicio.model.Servicio;
import com.duoc.msservicio.repository.ServicioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarServicio(ServicioRepository servicioRepository) {
        return args -> {

            if (servicioRepository.count() == 0) {

                Servicio servicio1 = new Servicio();
                servicio1.setNombre("Desayuno Buffet");
                servicio1.setDescripcion("Desayuno libre para huéspedes");
                servicio1.setPrecio(15000.0);
                servicio1.setTipoServicio("Alimentación");
                servicio1.setDisponibilidad(true);
                servicio1.setEstado("Disponible");
                servicio1.setHorarioDisponible("07:00 - 10:00");

                Servicio servicio2 = new Servicio();
                servicio2.setNombre("Spa");
                servicio2.setDescripcion("Acceso a spa y jacuzzi");
                servicio2.setPrecio(25000.0);
                servicio2.setTipoServicio("Bienestar");
                servicio2.setDisponibilidad(true);
                servicio2.setEstado("Disponible");
                servicio2.setHorarioDisponible("10:00 - 22:00");

                servicioRepository.save(servicio1);
                servicioRepository.save(servicio2);
            }
        };
    }
}