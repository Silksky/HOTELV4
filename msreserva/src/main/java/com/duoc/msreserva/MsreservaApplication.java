package com.duoc.msreserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsreservaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsreservaApplication.class, args);
    }
}