package com.ceiba.tipohabitacion.consulta;

import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import com.ceiba.tipohabitacion.puerto.dao.DaoTipoHabitacion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTipoHabitacion {

    private final DaoTipoHabitacion daoTipoHabitacion;

    public ManejadorListarTipoHabitacion(DaoTipoHabitacion daoTipoHabitacion) { this.daoTipoHabitacion = daoTipoHabitacion; }
    public List<DtoTipoHabitacion> ejecutar() { return this.daoTipoHabitacion.listar(); }
}
