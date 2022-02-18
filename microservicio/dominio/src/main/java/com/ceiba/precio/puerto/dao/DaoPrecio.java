package com.ceiba.precio.puerto.dao;

import com.ceiba.precio.modelo.dto.DtoPrecio;

import java.util.List;

public interface DaoPrecio {
    /**
     * Permite listar los precios
     * @return retorna la lista de precios
     */
    List<DtoPrecio> listar();

    /**
     * Permite listar el precio para un tipo de habitación en específico
     * @param idTipoHabitacion id tipo habitacion
     * @return retorna la lista con un elemento
     */
    List<DtoPrecio> listarPorIdTipoHabitacion(Long idTipoHabitacion);
 }
