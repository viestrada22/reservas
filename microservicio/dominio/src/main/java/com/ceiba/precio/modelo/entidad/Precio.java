package com.ceiba.precio.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Precio {

    private Long id;
    private int precioSemana;
    private int precioFinDeSemana;
    private Long idTipoHabitacion;

    public Precio(Long id, int precioSemana, int precioFinDeSemana, Long idTipoHabitacion) {
        validarObligatorio(idTipoHabitacion, "");
        this.id = id;
        this.precioSemana = precioSemana;
        this.precioFinDeSemana = precioFinDeSemana;
        this.idTipoHabitacion = idTipoHabitacion;
    }
}
