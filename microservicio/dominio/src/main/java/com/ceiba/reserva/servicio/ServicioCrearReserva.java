package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.DayOfWeek;
import java.util.Objects;

public class ServicioCrearReserva {

    private static final String EL_USUARIO_YA_ALCANZO_EL_LIMITE_DE_RESERVAS_DIARIAS = "El usuario ya alcanzo el limite de reservas diarias";
    private static final String EL_USUARIO_NO_PUEDE_HACER_RESERVAS_FINES_DE_SEMANA = "El usuario no puede hacer reservas para los fines de semana";
    private static final String EL_USUARIO_NO_PUEDE_HACER_RESERVAS_PARA_LOS_DOMINGOS = "El usuario no puede hacer reservas para los domingos";
    private static final String EL_USUARIO_NO_TIENE_PERMITIDO_HACER_RESERVAS_FINES_DE_SEMANA = "El usuario no tiene permitido hacer reservas los fines de semana";
    private static final String LA_FECHA_DE_RESERVA_DEBE_SER_MAYOR_A_LA_FECHA_ACTUAL = "La fecha de reserva debe ser mayor a la fecha actual";

    private static final Long CASUAL = 1L;
    private static final Long FRECUENTE = 2L;
    private static final Long MIEMBRO = 3L;
    private static final Long SUITE = 3L;

    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva) {
        validarQueLaFechaDeReservaSeaMayorALaFechaActual(reserva);
        validarFechaDeCreacionParaUsuariosCasualYFrecuente(reserva);
        validarLimiteDeReservas(reserva);
        validarFechaDeReservaParaUsuariosTipoCasual(reserva);
        validarFechaDeReservaParaUsuariosTipoFrecuente(reserva);
        aplicarDescuento(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarLimiteDeReservas(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getIdentificacionUsuario(), reserva.getFechaCreacion());
        if (existe) {
            throw new ExcepcionValorInvalido(EL_USUARIO_YA_ALCANZO_EL_LIMITE_DE_RESERVAS_DIARIAS);
        }
    }

    protected void validarFechaDeReservaParaUsuariosTipoCasual(Reserva reserva) {
        if (Objects.equals(reserva.getIdTipoUsuario(), CASUAL) && (reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SATURDAY || reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_PUEDE_HACER_RESERVAS_FINES_DE_SEMANA);
        }
    }

    protected void validarFechaDeReservaParaUsuariosTipoFrecuente(Reserva reserva) {
        if (Objects.equals(reserva.getIdTipoUsuario(), FRECUENTE) && reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_PUEDE_HACER_RESERVAS_PARA_LOS_DOMINGOS);
        }
    }

    protected void validarFechaDeCreacionParaUsuariosCasualYFrecuente(Reserva reserva) {
        if ((Objects.equals(reserva.getIdTipoUsuario(), CASUAL) || Objects.equals(reserva.getIdTipoUsuario(), FRECUENTE)) &&
                (reserva.getFechaCreacion().getDayOfWeek() == DayOfWeek.SATURDAY || reserva.getFechaCreacion().getDayOfWeek() == DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_TIENE_PERMITIDO_HACER_RESERVAS_FINES_DE_SEMANA);
        }
    }

    protected void validarQueLaFechaDeReservaSeaMayorALaFechaActual(Reserva reserva) {
        if (reserva.getFechaReserva().isEqual(reserva.getFechaCreacion()) || reserva.getFechaReserva().isBefore(reserva.getFechaCreacion())) {
            throw new ExcepcionValorInvalido(LA_FECHA_DE_RESERVA_DEBE_SER_MAYOR_A_LA_FECHA_ACTUAL);
        }
    }

    protected void aplicarDescuento(Reserva reserva) {
        if ((reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SUNDAY || reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SATURDAY) &&
                Objects.equals(reserva.getIdTipoUsuario(), MIEMBRO) && Objects.equals(reserva.getIdTipoHabitacion(), SUITE)) {
            reserva.setValorAPagar((long) (reserva.getValorAPagar() - (reserva.getValorAPagar() * 0.20)));
        } else if (Objects.equals(reserva.getIdTipoUsuario(), MIEMBRO) && Objects.equals(reserva.getIdTipoHabitacion(), SUITE)) {
            reserva.setValorAPagar((long) (reserva.getValorAPagar() - (reserva.getValorAPagar() * 0.20)));
        }
    }
}
