package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDate;
import java.util.UUID;

public class ComandoReservaTestDataBuilder {

    private Long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private Long valorAPagar;
    private Long idTipoHabitacion;
    private Long idTipoUsuario;

    public ComandoReservaTestDataBuilder() {
        identificacionUsuario = "54523600";
        nombreUsuario = UUID.randomUUID().toString();
        fechaReserva = LocalDate.now().plusDays(2);
        fechaCreacion = LocalDate.now();
        valorAPagar = 800000L;
        idTipoHabitacion = 3L;
        idTipoUsuario = 3L;
    }

    public ComandoReserva build() { return new ComandoReserva(id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario); }
}
