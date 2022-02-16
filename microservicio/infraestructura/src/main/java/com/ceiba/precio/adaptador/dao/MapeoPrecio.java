package com.ceiba.precio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.precio.modelo.dto.DtoPrecio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPrecio implements RowMapper<DtoPrecio>, MapperResult {
    @Override
    public DtoPrecio mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idPrecio = resultSet.getLong("idPrecio");
        int precioSemana = resultSet.getInt("precioSemana");
        int precioFinDeSemana = resultSet.getInt("precioFinDeSemana");
        Long idTipoHabitacion = resultSet.getLong("idTipoHabitacion");
        return new DtoPrecio(idPrecio, precioSemana, precioFinDeSemana, idTipoHabitacion);
    }
}
