package com.ceiba.reserva.consulta;

import com.ceiba.reserva.modelo.dto.DtoReserva;
import com.ceiba.reserva.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarReservasPorIdentificacionUsuario {

    private final DaoReserva daoReserva;

    public ManejadorListarReservasPorIdentificacionUsuario(DaoReserva daoReserva) { this.daoReserva = daoReserva; }
    public List<DtoReserva> ejecutar(String identificacionUsuario){ return this.daoReserva.listarPorIdentificacionUsuario(identificacionUsuario); }
}
