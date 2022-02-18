package com.ceiba.reserva.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    @Test
    @DisplayName("Debería crear la reserva correctamente")
    void deberiaCrearLaReservaCorrectamente() {
        //arrange
        LocalDate fechaReserva = LocalDate.now().plusDays(2);
        LocalDate fechaCreacion = LocalDate.now();
        //act
        Reserva reserva = new ReservaTestDataBuilder().conFechaReserva(fechaReserva).conFechaCreacion(fechaCreacion).conId(1L).build();
        //assert
        assertEquals("123456789", reserva.getIdentificacionUsuario());
        assertEquals("test1", reserva.getNombreUsuario());
        assertEquals(fechaReserva, reserva.getFechaReserva());
        assertEquals(fechaCreacion, reserva.getFechaCreacion());
        assertEquals(260000, reserva.getValorAPagar());
        assertEquals(1L, reserva.getIdTipoHabitacion());
        assertEquals(3L, reserva.getIdTipoUsuario());
    }

    @Test
    @DisplayName("Debería fallar la reserva sin la identificación del usuario")
    void deberiaFallarSinIdentificacionUsuario() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conIdentificacionUsuario(null).conId(1L);
        //act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar la identificación del usuario");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin el nombre del usuario")
    void deberiaFallarSinNombreUsuario() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conNombreUsuario(null).conId(1L);
        //act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin fecha de reserva")
    void deberiaFallarSinFechaReserva() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conFechaReserva(null).conId(1L);
        //act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de reserva");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin fecha de creación")
    void deberiaFallarSinFechaCreacion() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conFechaCreacion(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin valor a pagar")
    void deberiaFallarSinValorAPagar() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conValorAPagar(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar el valor a pagar");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin id tipo habitación")
    void deberiaFallarSinIdTipoHabitacion() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conIdTipoHabitacion(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de habitación");
    }

    @Test
    @DisplayName("Debería fallar la reserva sin id tipo usuario")
    void deberiaFallarSinIdTipoUsuario() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = ReservaTestDataBuilder.unaReserva().conIdTipoUsuario(null).conId(1L);
        // act - assert
        BasePrueba.assertThrows(() -> {
            reservaTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de usuario");
    }
}
