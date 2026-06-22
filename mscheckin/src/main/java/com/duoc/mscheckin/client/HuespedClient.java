package com.duoc.mscheckin.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mshuesped")
public interface HuespedClient {

    @GetMapping("/huesped/{idHuesped}")
    Object buscarHuespedPorId(@PathVariable Integer idHuesped);

}