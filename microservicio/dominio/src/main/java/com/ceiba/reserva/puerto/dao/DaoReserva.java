package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {
    /**
     * Permite listar reservas
     * @return las reservas
     */
    List<DtoReserva> listar();

    /**
     * permite listar reservas por identificación de usuario
     * @return retorna lista de reservas por identifiacionUsuario
     */
    List<DtoReserva> listarPorId(Long id);
 }
