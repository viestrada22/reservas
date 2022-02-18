package com.ceiba.precio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.precio.modelo.dto.DtoPrecio;
import com.ceiba.precio.puerto.dao.DaoPrecio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPrecioMysql implements DaoPrecio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "precio", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "precio", value = "listarPorIdTipoHabitacion")
    private static String sqlListarPorIdTipoHabitacion;

    public DaoPrecioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPrecio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPrecio());
    }

    @Override
    public List<DtoPrecio> listarPorIdTipoHabitacion(Long idTipoHabitacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTipoHabitacion", idTipoHabitacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdTipoHabitacion,paramSource, new MapeoPrecio() );
    }
}
