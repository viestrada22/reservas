package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.consulta.ManejadorListarReservasPorId;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags = {"Controlador consulta reserva"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservas manejadorListarReservas;
    private final ManejadorListarReservasPorId manejadorListarReservasPorId;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas, ManejadorListarReservasPorId manejadorListarReservasPorId) {
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorListarReservasPorId = manejadorListarReservasPorId;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar() { return this.manejadorListarReservas.ejecutar(); }

    @GetMapping("/{id}")
    @ApiOperation("Listar reservas por id")
    public List<DtoReserva> listarPorId(@PathVariable Long id) { return this.manejadorListarReservasPorId.ejecutar(id); }
}
