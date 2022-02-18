package com.ceiba.tipousuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class TipoUsuario {

    private static final String TIPO_USUARIO_OBLIGATORIO = "El tipo de usuario es obligatorio";

    private final Long id;
    private final String tipoUsuario;

    public TipoUsuario(Long id, String tipoUsuario) {
        validarObligatorio(tipoUsuario, TIPO_USUARIO_OBLIGATORIO);
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }
}
