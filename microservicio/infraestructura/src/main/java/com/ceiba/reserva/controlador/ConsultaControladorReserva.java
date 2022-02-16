package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.consulta.ManejadorListarReservasPorIdentificacionUsuario;
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
    private final ManejadorListarReservasPorIdentificacionUsuario manejadorListarReservasPorIdentificacionUsuario;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas, ManejadorListarReservasPorIdentificacionUsuario manejadorListarReservasPorIdentificacionUsuario) {
        this.manejadorListarReservas = manejadorListarReservas;
        this.manejadorListarReservasPorIdentificacionUsuario = manejadorListarReservasPorIdentificacionUsuario;
    }

    @GetMapping
    @ApiOperation("Listar reservas")
    public List<DtoReserva> listar() { return this.manejadorListarReservas.ejecutar(); }

    @GetMapping("/{identificacionUsuario}")
    @ApiOperation("Listar reservas por identificacion del usuario")
    public List<DtoReserva> listarPorIdentificacionUsuario(@PathVariable String identificacionUsuario) { return this.manejadorListarReservasPorIdentificacionUsuario.ejecutar(identificacionUsuario); }
}
