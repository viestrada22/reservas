package com.ceiba.tipousuario.controlador;

import com.ceiba.tipousuario.consulta.ManejadorListarTipoUsuario;
import com.ceiba.tipousuario.modelo.dto.DtoTipoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipousuario")
@Api(tags = {"Controlador consulta tipousuario"})
public class ConsultaControladorTipoUsuario {

    private final ManejadorListarTipoUsuario manejadorListarTipoUsuario;

    public ConsultaControladorTipoUsuario(ManejadorListarTipoUsuario manejadorListarTipoUsuario) {
        this.manejadorListarTipoUsuario = manejadorListarTipoUsuario;
    }

    @GetMapping
    @ApiOperation("Listar tipos de usuario")
    public List<DtoTipoUsuario> listar() { return this.manejadorListarTipoUsuario.ejecutar(); }
}
