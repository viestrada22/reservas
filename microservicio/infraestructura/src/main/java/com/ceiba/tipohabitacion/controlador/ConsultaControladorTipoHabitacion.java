package com.ceiba.tipohabitacion.controlador;

import com.ceiba.tipohabitacion.consulta.ManejadorListarTipoHabitacion;
import com.ceiba.tipohabitacion.modelo.dto.DtoTipoHabitacion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipohabitacion")
@Api(tags = {"Controlador consulta tipohabitacion"})
public class ConsultaControladorTipoHabitacion {

    private final ManejadorListarTipoHabitacion manejadorListarTipoHabitacion;

    public ConsultaControladorTipoHabitacion(ManejadorListarTipoHabitacion manejadorListarTipoHabitacion) {
        this.manejadorListarTipoHabitacion = manejadorListarTipoHabitacion;
    }

    @GetMapping
    @ApiOperation("Listar los tipos de habitación")
    public List<DtoTipoHabitacion> listar() { return this.manejadorListarTipoHabitacion.ejecutar(); }
}
