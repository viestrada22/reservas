package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;

public class ReservaTestDataBuilder {

    private Long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private Long valorAPagar;
    private Long idTipoHabitacion;
    private Long idTipoUsuario;

    public ReservaTestDataBuilder() {
        identificacionUsuario = "123456789";
        nombreUsuario = "test1";
        fechaReserva = LocalDate.now().plusDays(2);
        fechaCreacion = LocalDate.now();
        valorAPagar = 260000L;
        idTipoHabitacion = 1L;
        idTipoUsuario = 3L;
    }

    public ReservaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ReservaTestDataBuilder conIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
        return this;
    }

    public ReservaTestDataBuilder conNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public ReservaTestDataBuilder conFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
        return this;
    }

    public ReservaTestDataBuilder conFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public ReservaTestDataBuilder conValorAPagar(Long valorAPagar) {
        this.valorAPagar = valorAPagar;
        return this;
    }

    public ReservaTestDataBuilder conIdTipoHabitacion(Long idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
        return this;
    }

    public ReservaTestDataBuilder conIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        return this;
    }

    public Reserva build() { return new Reserva(id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario); }
    public static ReservaTestDataBuilder unaReserva() { return new ReservaTestDataBuilder(); }
}
