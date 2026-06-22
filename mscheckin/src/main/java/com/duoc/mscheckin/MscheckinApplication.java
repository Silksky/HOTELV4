package com.duoc.mscheckin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MscheckinApplication {
    public static void main(String[] args) {
        SpringApplication.run(MscheckinApplication.class, args);
    }
}