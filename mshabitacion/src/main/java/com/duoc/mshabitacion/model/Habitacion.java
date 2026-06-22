package com.duoc.mshabitacion.model;

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
@Table(name = "habitacion")
public class Habitacion {

    @Id
    @Column(name = "id_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabitacion;

    @Column(name = "numero_habitacion", nullable = false, unique = true)
    private Integer numeroHabitacion;

    @Column(name = "tipo_habitacion", nullable = false)
    private String tipoHabitacion;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "precio_noche", nullable = false)
    private Double precioNoche;

    @Column(name = "estado", nullable = false)
    private Boolean disponible;

    @Column(name = "descripcion")
    private String descripcion;

}
