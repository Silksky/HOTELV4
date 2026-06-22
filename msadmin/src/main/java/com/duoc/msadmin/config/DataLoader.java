package com.duoc.msadmin.config;

import com.duoc.msadmin.model.Admin;
import com.duoc.msadmin.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner cargarAdmins(AdminRepository adminRepository) {
        return args -> {

            if (adminRepository.count() == 0) {

                Admin admin1 = new Admin();
                admin1.setNombre("Administrador");
                admin1.setContrasena("1234");

                Admin admin2 = new Admin();
                admin2.setNombre("Recepcionista");
                admin2.setContrasena("1234");

                adminRepository.save(admin1);
                adminRepository.save(admin2);
            }
        };
    }
}