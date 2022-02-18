package com.ceiba.reserva.servicio;

import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarReservaTest {

    @Test
    @DisplayName("Deberia iliminar la reserva llamando al repositorio")
    void deberiaEliminarLaReservaLlamandoAlRepositorio() {
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva);

        servicioEliminarReserva.ejecutar(1L);

        Mockito.verify(repositorioReserva, Mockito.times(1)).eliminar(1L);
    }
}
