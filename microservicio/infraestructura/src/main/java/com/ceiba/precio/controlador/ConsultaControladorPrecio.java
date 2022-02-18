package com.ceiba.precio.controlador;

import com.ceiba.precio.consulta.ManejadorListarPrecio;
import com.ceiba.precio.consulta.ManejadorListarPrecioPorIdTipoHabitacion;
import com.ceiba.precio.modelo.dto.DtoPrecio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/precios")
@Api(tags = {"Controlador consulta precio"})
public class ConsultaControladorPrecio {

    private final ManejadorListarPrecio manejadorListarPrecio;
    private final ManejadorListarPrecioPorIdTipoHabitacion manejadorListarPrecioPorIdTipoHabitacion;

    public ConsultaControladorPrecio(ManejadorListarPrecio manejadorListarPrecio, ManejadorListarPrecioPorIdTipoHabitacion manejadorListarPrecioPorIdTipoHabitacion) {
        this.manejadorListarPrecio = manejadorListarPrecio;
        this.manejadorListarPrecioPorIdTipoHabitacion = manejadorListarPrecioPorIdTipoHabitacion;
    }

    @GetMapping()
    @ApiOperation("Listar los precios de las habitaciones")
    public List<DtoPrecio> listar() { return this.manejadorListarPrecio.ejecutar(); }

    @GetMapping("/{idTipoHabitacion}")
    @ApiOperation("Lista de precios por tipo de habitación")
    public List<DtoPrecio> listarPorIdTipoHabitacion(@PathVariable Long idTipoHabitacion) { return this.manejadorListarPrecioPorIdTipoHabitacion.ejecutar(idTipoHabitacion); }
}
