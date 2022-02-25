package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearReservaTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha de reserva sea igual o menor a la fecha de creación")
    void deberiaLanzarUnaExepcionCuandoLaFechaDeReservaSeaIgualOMenorALaDeCreacion() {
        //arrange
        Reserva reserva = new ReservaTestDataBuilder().conFechaReserva(LocalDate.now().minusDays(1)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(6L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "La fecha de reserva debe ser mayor a la fecha actual");
    }

    @Test
    @DisplayName("Debería lanzar una exepcion cuando el usuario limite el numero de resercas diarias")
    void deberiaLanzarUnaExepcionCuandoSeAlcanceElLimiteDeReservasDiarias() {
        //arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.any())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El usuario ya alcanzo el limite de reservas diarias");
    }

    @Test
    @DisplayName("Deberia lanzar una exepción cuando un usuario de tipo casual intente reservar para estadia fin de semana")
    void deberiaLanzarUnaExepcionCuandoUnUsuarioTipoCasualIntenteReservarParaEstadiaFinDeSemana() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdTipoUsuario(1L).conFechaReserva(LocalDate.now().plusDays(2)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(6L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El usuario no puede hacer reservas para los fines de semana");
    }

    @Test
    @DisplayName("Deberia lanzar una exepción cuando un usuario de tipo frecuente intente reservar para estadia los domingos")
    void deberiaLanzarUnaExepcionCuandoUnUsuarioTipoCasualIntenteReservarParaEstadiaLosDomingos() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdTipoUsuario(2L).conFechaReserva(LocalDate.now().plusDays(2)).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(6L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El usuario no puede hacer reservas para los domingos");
    }

    @Test
    @DisplayName("Deberia lanzar una exepción cuando un usuario de tipo frecuente o casual intente reserva un fin de semana")
    void deberiaLanzarUnaExepcionCuandoUnUsuarioTipoCasualOFrecuenteIntentenReservarSabadoODomingo() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conIdTipoUsuario(1L)
                .conFechaCreacion(LocalDate.of(2022, Month.FEBRUARY, 19))
                .conFechaReserva(LocalDate.of(2022, Month.FEBRUARY, 22))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(6L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class, "El usuario no tiene permitido hacer reservas los fines de semana");
    }

    @Test
    @DisplayName("Deberia crear la reserva de manera correcta")
    void deberiaCrearLaReservaDeManeraCorrecta() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.any())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(6L);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act
        Long id = servicioCrearReserva.ejecutar(reserva);
        // assert
        assertEquals(6L, id);
        assertEquals(520000, reserva.getValorAPagar());
        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }


}
