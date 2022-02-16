package com.ceiba.tipohabitacion.adptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoHabitacion implements RowMapper<DtoTipoHabitacion>, MapperResult {
    @Override
    public DtoTipoHabitacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idTipoHabitacion = resultSet.getLong("idTipoHabitacion");
        String tipoHabitacion = resultSet.getString("tipoHabitacion");
        return new DtoTipoHabitacion(idTipoHabitacion, tipoHabitacion);
    }
}
