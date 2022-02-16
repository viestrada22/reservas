package com.ceiba.tipousuario.consulta;

import com.ceiba.tipousuario.modelo.dto.DtoTipoUsuario;
import com.ceiba.tipousuario.puerto.dao.DaoTipoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTipoUsuario {

    private final DaoTipoUsuario daoTipoUsuario;

    public ManejadorListarTipoUsuario(DaoTipoUsuario daoTipoUsuario) { this.daoTipoUsuario = daoTipoUsuario; }
    public List<DtoTipoUsuario> ejecutar() { return this.daoTipoUsuario.listar(); }
}
