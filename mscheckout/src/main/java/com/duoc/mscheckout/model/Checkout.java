package com.duoc.mscheckout.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkout")
public class Checkout {

    @Id
    @Column(name = "id_checkout")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCheckout;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;

    @Column(name = "id_cliente", nullable = false)
    private Integer idHuesped;

    @Column(name = "id_habitacion", nullable = false)
    private Integer idHabitacion;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "monto_pagado", nullable = false)
    private Double montoPagado;
}
