package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDate;

public interface RepositorioReserva {
    /**
     * Permite crear una reserva
     * @param reserva datos de la reserva
     * @return devuelve el id de la reserva
     */
    Long crear(Reserva reserva);

    /**
     * Permite actualizar una reserva
     * @param reserva datos de la reserva
     */
    void actualizar(Reserva reserva);

    /**
     * Permite eliminar una reserva
     * @param id id de la reserva
     */
    void eliminar(Long id);

    /**
     * Permite validar si ya existe una reserva hecha por el usuario el mismo día
     * @param identificacionUsuario identificación del usuario
     * @param fechaCreacion fecha en la que se creo la reserva
     * @return retorna un true o false
     */
    boolean existe(String identificacionUsuario, LocalDate fechaCreacion);

    /**
     * Permite validar si una reserva en específico existe
     * @param id id de la reserva
     * @return retorna un true o false
     */
    boolean existePorId(Long id);
}
