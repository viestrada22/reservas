package com.ceiba.reserva.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoReserva {

    private Long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private Long valorAPagar;
    private Long idTipoHabitacion;
    private Long idTipoUsuario;
}
