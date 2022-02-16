package com.ceiba.tipohabitacion.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoHabitacion {
    private static final String TIPO_HABITACION_OBLIGATORIO = "El tipo de habitación es obligatorio";
    private final Long idTipoHabitacion;
    private final String tipoHabitacion;

    public TipoHabitacion(Long idTipoHabitacion, String tipoHabitacion) {
        validarObligatorio(tipoHabitacion, TIPO_HABITACION_OBLIGATORIO);
        this.idTipoHabitacion = idTipoHabitacion;
        this.tipoHabitacion = tipoHabitacion;
    }
}
