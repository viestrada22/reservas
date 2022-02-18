package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Reserva {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_USUARIO = "Se debe ingresar la identificación del usuario";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA = "Se debe ingresar la fecha de reserva";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR = "Se debe ingresar el valor a pagar";
    private static final String SE_DEBE_INGRESAR_EL_ID_TIPO_HABITACION = "Se debe ingresar el tipo de habitación";
    private static final String SE_DEBE_INGRESAR_EL_ID_TIPO_USUARIO = "Se debe ingresar el tipo de usuario";


    private Long id;
    private String identificacionUsuario;
    private String nombreUsuario;
    private LocalDate fechaReserva;
    private LocalDate fechaCreacion;
    private Long valorAPagar;
    private Long idTipoHabitacion;
    private Long idTipoUsuario;

    public Reserva(Long id, String identificacionUsuario, String nombreUsuario, LocalDate fechaReserva, LocalDate fechaCreacion, Long valorAPagar, Long idTipoHabitacion, Long idTipoUsuario) {
        validarObligatorio(identificacionUsuario, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_USUARIO);
        validarObligatorio(nombreUsuario, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(fechaReserva, SE_DEBE_INGRESAR_LA_FECHA_DE_RESERVA);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(valorAPagar, SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR);
        validarObligatorio(idTipoHabitacion, SE_DEBE_INGRESAR_EL_ID_TIPO_HABITACION);
        validarObligatorio(idTipoUsuario, SE_DEBE_INGRESAR_EL_ID_TIPO_USUARIO);

        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.fechaReserva = fechaReserva;
        this.fechaCreacion = fechaCreacion;
        this.valorAPagar = valorAPagar;
        this.idTipoHabitacion = idTipoHabitacion;
        this.idTipoUsuario = idTipoUsuario;
    }
}
