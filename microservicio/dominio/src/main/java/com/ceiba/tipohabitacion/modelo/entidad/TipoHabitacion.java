package com.ceiba.tipohabitacion.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoHabitacion {
    private static final String TIPO_HABITACION_OBLIGATORIO = "El tipo de habitación es obligatorio";
    private final Long id;
    private final String tipoHabitacion;

    public TipoHabitacion(Long id, String tipoHabitacion) {
        validarObligatorio(tipoHabitacion, TIPO_HABITACION_OBLIGATORIO);
        this.id = id;
        this.tipoHabitacion = tipoHabitacion;
    }
}
