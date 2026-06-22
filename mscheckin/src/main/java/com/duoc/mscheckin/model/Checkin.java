package com.duoc.mscheckin.model;

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
@Table(name = "checkin")
public class Checkin {

    @Id
    @Column(name = "id_checkin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCheckin;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDateTime fechaIngreso;


    @Column(name = "fecha_salida", nullable = false)
    private LocalDateTime fechaSalida;


    @Column(name = "id_huesped", nullable = false)
    private Integer idHuesped;


    @Column(name = "id_habitacion", nullable = false)
    private Integer idHabitacion;

}