package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;


public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_ENCUENTRA_EN_EL_SISTEMA = "La reserva no se encuentra en el sistema";

    private final RepositorioReserva repositorioReserva;
    private final ServicioCrearReserva servicioCrearReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva, ServicioCrearReserva servicioCrearReserva) {
        this.repositorioReserva = repositorioReserva;
        this.servicioCrearReserva = servicioCrearReserva;
    }

    public void ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        this.servicioCrearReserva.validarQueLaFechaDeReservaSeaMayorALaFechaActual(reserva);
        this.servicioCrearReserva.validarFechaDeCreacionParaUsuariosCasualYFrecuente(reserva);
        this.servicioCrearReserva.validarFechaDeReservaParaUsuariosTipoCasual(reserva);
        this.servicioCrearReserva.validarFechaDeReservaParaUsuariosTipoFrecuente(reserva);
        this.servicioCrearReserva.aplicarDescuento(reserva);
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existePorId(reserva.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_NO_ENCUENTRA_EN_EL_SISTEMA);
        }
    }
}
