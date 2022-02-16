package com.ceiba.precio.controlador;

import com.ceiba.precio.consulta.ManejadorListarPrecio;
import com.ceiba.precio.modelo.dto.DtoPrecio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/precios")
@Api(tags = {"Controlador consulta precio"})
public class ConsultaControladorPrecio {

    private final ManejadorListarPrecio manejadorListarPrecio;

    public ConsultaControladorPrecio(ManejadorListarPrecio manejadorListarPrecio) {
        this.manejadorListarPrecio = manejadorListarPrecio;
    }

    @GetMapping()
    @ApiOperation("Listar los precios de las habitaciones")
    public List<DtoPrecio> listar() { return this.manejadorListarPrecio.ejecutar(); }
}
