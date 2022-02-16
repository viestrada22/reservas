package com.ceiba.tipohabitacion.puerto.dao;

import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;

import java.util.List;

public interface DaoTipoHabitacion {
    /**
     * Permite listar los tipos de habitaciones
     * @return retorna una lista de dtoTipoHabitacion
     */
    List<DtoTipoHabitacion> listar();
}
