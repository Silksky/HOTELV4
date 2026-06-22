package com.duoc.msreserva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mstipohabitacion")
public interface TipoHabitacionClient {

    @GetMapping("/tipohabitacion/{idTipoHabitacion}")
    Object buscarTipoHabitacionPorId(@PathVariable Integer idTipoHabitacion);

}