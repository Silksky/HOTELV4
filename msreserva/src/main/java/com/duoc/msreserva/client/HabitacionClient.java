package com.duoc.msreserva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mshabitacion")
public interface HabitacionClient {

    @GetMapping("/habitacion/{idHabitacion}")
    Object buscarHabitacionPorId(@PathVariable Integer idHabitacion);

}