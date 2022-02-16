package com.ceiba.tipousuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tipousuario.modelo.dto.DtoTipoUsuario;
import com.ceiba.tipousuario.puerto.dao.DaoTipoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTipoUsuarioMysql implements DaoTipoUsuario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tipousuario", value = "listar")
    private static String sqlListar;

    public DaoTipoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTipoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTipoUsuario());
    }
}
