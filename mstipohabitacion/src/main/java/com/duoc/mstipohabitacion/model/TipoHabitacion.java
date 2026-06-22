package com.duoc.mstipohabitacion.model;

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
@Table(name = "tipo_habitacion")
public class TipoHabitacion {

    @Id
    @Column(name = "id_tipo_habitacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoHabitacion;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidadMaxima;

    @Column(name = "precio_base", nullable = false)
    private Double precioBase;

    @Column(name = "caracteristicas")
    private String caracteristicas;

    @Column(name = "estado", nullable = false)
    private String estado;
}
