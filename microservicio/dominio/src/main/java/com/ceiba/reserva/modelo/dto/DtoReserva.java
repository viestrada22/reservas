package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoReserva {

    private Long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private Long valorAPagar;
    private Long idTipoHabitacion;
    private Long idTipoUsuario;
}
