package com.ceiba.tipousuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipousuario.modelo.dto.DtoTipoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoTipoUsuario implements RowMapper<DtoTipoUsuario>, MapperResult {

    @Override
    public DtoTipoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idTipoUsuario = resultSet.getLong("idTipoUsuario");
        String tipoUsuario = resultSet.getString("tipoUsuario");
        return new DtoTipoUsuario(idTipoUsuario, tipoUsuario);
    }
}
