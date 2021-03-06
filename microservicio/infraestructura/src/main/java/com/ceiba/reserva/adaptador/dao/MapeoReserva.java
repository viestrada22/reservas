package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String identificacionUsuario = resultSet.getString("identificacionUsuario");
        String nombreUsuario = resultSet.getString("nombreUsuario");
        LocalDate fechaReserva = extraerLocalDate(resultSet, "fechaReserva");
        LocalDate fechaCreacion = extraerLocalDate(resultSet,"fechaCreacion");
        Long valorAPagar = resultSet.getLong("valorAPagar");
        Long idTipoHabitacion = resultSet.getLong("idTipoHabitacion");
        Long idTipoUsuario = resultSet.getLong("idTipoUsuario");
        return new DtoReserva(id, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario);
    }
}
