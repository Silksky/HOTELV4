package com.duoc.mstipohabitacion.config;

import com.duoc.mstipohabitacion.model.TipoHabitacion;
import com.duoc.mstipohabitacion.repository.TipoHabitacionRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarTipoHabitacion(TipoHabitacionRepository tipoHabitacionRepository) {
        return args -> {

            if (tipoHabitacionRepository.count() == 0) {

                TipoHabitacion tipo1 = new TipoHabitacion();
                tipo1.setNombre("Individual");
                tipo1.setDescripcion("Habitación para una persona");
                tipo1.setCapacidadMaxima(1);
                tipo1.setPrecioBase(50000.0);
                tipo1.setCaracteristicas("1 cama individual, WiFi, TV, baño privado");
                tipo1.setEstado("Disponible");

                TipoHabitacion tipo2 = new TipoHabitacion();
                tipo2.setNombre("Doble");
                tipo2.setDescripcion("Habitación para dos personas");
                tipo2.setCapacidadMaxima(2);
                tipo2.setPrecioBase(80000.0);
                tipo2.setCaracteristicas("1 cama matrimonial, WiFi, TV, baño privado");
                tipo2.setEstado("Disponible");

                TipoHabitacion tipo3 = new TipoHabitacion();
                tipo3.setNombre("Suite");
                tipo3.setDescripcion("Habitación de lujo con sala de estar");
                tipo3.setCapacidadMaxima(4);
                tipo3.setPrecioBase(150000.0);
                tipo3.setCaracteristicas("Cama King, sala de estar, minibar, jacuzzi");
                tipo3.setEstado("Disponible");

                TipoHabitacion tipo4 = new TipoHabitacion();
                tipo4.setNombre("Familiar");
                tipo4.setDescripcion("Habitación para grupos familiares");
                tipo4.setCapacidadMaxima(5);
                tipo4.setPrecioBase(120000.0);
                tipo4.setCaracteristicas("2 camas matrimoniales, WiFi, TV, baño privado");
                tipo4.setEstado("Disponible");

                tipoHabitacionRepository.save(tipo1);
                tipoHabitacionRepository.save(tipo2);
                tipoHabitacionRepository.save(tipo3);
                tipoHabitacionRepository.save(tipo4);
            }
        };
    }
}