package com.ceiba.precio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoPrecio {
    private Long id;
    private int precioSemana;
    private int precioFinDeSemana;
    private Long idTipoHabitacion;
}
