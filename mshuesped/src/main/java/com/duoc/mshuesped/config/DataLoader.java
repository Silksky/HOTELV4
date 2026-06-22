package com.duoc.mshuesped.config;

import com.duoc.mshuesped.model.Huesped;
import com.duoc.mshuesped.repository.HuespedRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarHuesped(HuespedRepository huespedRepository) {
        return args -> {

            if (huespedRepository.count() == 0) {

                Huesped huesped1 = new Huesped();
                huesped1.setNombre("Juan");
                huesped1.setApellido("Pérez");
                huesped1.setEmail("juan.perez@example.com");
                huesped1.setTelefono("5693652 8971");
                huesped1.setRut("20.123.123-1");
                huesped1.setDireccion("calle verdadera 321");
                huesped1.setCiudad("Barcelona");
                huesped1.setPais("España");

                Huesped huesped2 = new Huesped();
                huesped2.setNombre("Mario");
                huesped2.setApellido("Mesas");
                huesped2.setEmail("mesas.mario@example.com");
                huesped2.setTelefono("56913339482");
                huesped2.setRut("7.123.123-3");
                huesped2.setDireccion("calle falsa 123");
                huesped2.setCiudad("Santiago");
                huesped2.setPais("Chile");


                huespedRepository.save(huesped1);
                huespedRepository.save(huesped2);
            }
        };
    }
}