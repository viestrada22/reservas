package com.ceiba.precio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.precio.modelo.dto.DtoPrecio;
import com.ceiba.precio.puerto.dao.DaoPrecio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPrecioMysql implements DaoPrecio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "precio", value = "listar")
    private static String sqlListar;

    public DaoPrecioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPrecio> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPrecio());
    }
}
