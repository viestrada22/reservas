package com.ceiba.tipousuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoUsuario {

    private static final String TIPO_USUARIO_OBLIGATORIO = "El tipo de usuario es obligatorio";

    private final Long idTipoUsuario;
    private final String tipoUsuario;

    public TipoUsuario(Long idTipoUsuario, String tipoUsuario) {
        validarObligatorio(tipoUsuario, TIPO_USUARIO_OBLIGATORIO);
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }
}
