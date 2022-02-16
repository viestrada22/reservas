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

        Long idReserva = resultSet.getLong("idReserva");
        String identificacionUsuario = resultSet.getString("identificacionUsuario");
        String nombreUsuario = resultSet.getString("nombreUsuario");
        LocalDate fechaReserva = extraerLocalDate(resultSet, "fechaReserva");
        LocalDate fechaCreacion = extraerLocalDate(resultSet,"fechaCreacion");
        int valorAPagar = resultSet.getInt("valorAPagar");
        Long idTipoHabitacion = resultSet.getLong("idTipoHabitacion");
        Long idTipoUsuario = resultSet.getLong("idTipoUsuario");
        return new DtoReserva(idReserva, identificacionUsuario, nombreUsuario, fechaReserva, fechaCreacion, valorAPagar, idTipoHabitacion, idTipoUsuario);
    }
}
