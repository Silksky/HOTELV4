package com.duoc.mshabitacion.config;

import com.duoc.mshabitacion.model.Habitacion;
import com.duoc.mshabitacion.repository.HabitacionRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarHabitaciones(HabitacionRepository habitacionRepository) {
        return args -> {

            if (habitacionRepository.count() == 0) {

                Habitacion habitacion1 = new Habitacion();
                habitacion1.setNumeroHabitacion(1);
                habitacion1.setTipoHabitacion("Sencilla");
                habitacion1.setCapacidad(1);
                habitacion1.setPrecioNoche(100.00);
                habitacion1.setDisponible(false);
                habitacion1.setDescripcion("Habitación sencilla con vista al mar");

                Habitacion habitacion2 = new Habitacion();
                habitacion2.setNumeroHabitacion(2);
                habitacion2.setTipoHabitacion("Doble");
                habitacion2.setCapacidad(2);
                habitacion2.setPrecioNoche(200.00);
                habitacion2.setDisponible(true);
                habitacion2.setDescripcion("Habitación doble con vista al jardín");


                habitacionRepository.save(habitacion1);
                habitacionRepository.save(habitacion2);
            }
        };
    }
}