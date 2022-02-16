package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.DayOfWeek;
import java.util.Objects;

public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_ENCUENTRA_EN_EL_SISTEMA = "La reserva no se encuentra en el sistema";
    private static final String EL_USUARIO_NO_PUEDE_HACER_RESERVAS_FINES_DE_SEMANA = "El usuario no puede hacer reservas para los fines de semana";
    private static final String EL_USUARIO_NO_PUEDE_HACER_RESERVAS_PARA_LOS_DOMINGOS = "El usuario no puede hacer reservas para los domingos";
    private static final String EL_USUARIO_NO_TIENE_PERMITIDO_HACER_RESERVAS_FINES_DE_SEMANA = "El usuario no tiene permitido hacer reservas los fines de semana";
    private static final String LA_FECHA_DE_RESERVA_DEBE_SER_MAYOR_A_LA_FECHA_ACTUAL = "La fecha de reserva debe ser mayor a la fecha actual";

    private static final Long CASUAL = 1L;
    private static final Long FRECUENTE = 2L;

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        validarQueLaFechaDeReservaSeaMayorALaFechaActual(reserva);
        validarFechaDeCreacionParaUsuariosCasualYFrecuente(reserva);
        validarFechaDeReservaParaUsuariosTipoCasual(reserva);
        validarFechaDeReservaParaUsuariosTipoFrecuente(reserva);
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existePorId(reserva.getIdReserva());
        if (!existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_NO_ENCUENTRA_EN_EL_SISTEMA);
        }
    }

    private void validarFechaDeReservaParaUsuariosTipoCasual(Reserva reserva) {
        if (Objects.equals(reserva.getIdTipoUsuario(), CASUAL) && (reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SATURDAY || reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_PUEDE_HACER_RESERVAS_FINES_DE_SEMANA);
        }
    }

    private void validarFechaDeReservaParaUsuariosTipoFrecuente(Reserva reserva) {
        if (Objects.equals(reserva.getIdTipoUsuario(), FRECUENTE) && reserva.getFechaReserva().getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_PUEDE_HACER_RESERVAS_PARA_LOS_DOMINGOS);
        }
    }

    private void validarFechaDeCreacionParaUsuariosCasualYFrecuente(Reserva reserva) {
        if ((Objects.equals(reserva.getIdTipoUsuario(), CASUAL) || Objects.equals(reserva.getIdTipoUsuario(), FRECUENTE)) &&
                (reserva.getFechaCreacion().getDayOfWeek() == DayOfWeek.SATURDAY || reserva.getFechaCreacion().getDayOfWeek() == DayOfWeek.SUNDAY)) {
            throw new ExcepcionValorInvalido(EL_USUARIO_NO_TIENE_PERMITIDO_HACER_RESERVAS_FINES_DE_SEMANA);
        }
    }

    private void validarQueLaFechaDeReservaSeaMayorALaFechaActual(Reserva reserva) {
        if (reserva.getFechaReserva().isEqual(reserva.getFechaCreacion()) || reserva.getFechaReserva().isBefore(reserva.getFechaCreacion())) {
            throw new ExcepcionValorInvalido(LA_FECHA_DE_RESERVA_DEBE_SER_MAYOR_A_LA_FECHA_ACTUAL);
        }
    }
}
