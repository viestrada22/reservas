package com.ceiba.tipousuario.puerto.dao;

import com.ceiba.tipousuario.modelo.dto.DtoTipoUsuario;

import java.util.List;

public interface DaoTipoUsuario {
    /**
     * Permite listar los tipos de usuario
     * @return lista de dtoTipoUsuario
     */
    List<DtoTipoUsuario> listar();
}
