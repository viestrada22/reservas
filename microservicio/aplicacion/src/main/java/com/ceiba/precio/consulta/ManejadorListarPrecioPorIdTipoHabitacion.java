package com.ceiba.precio.consulta;

import com.ceiba.precio.modelo.dto.DtoPrecio;
import com.ceiba.precio.puerto.dao.DaoPrecio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPrecioPorIdTipoHabitacion {

    private final DaoPrecio daoPrecio;

    public ManejadorListarPrecioPorIdTipoHabitacion(DaoPrecio daoPrecio) { this.daoPrecio = daoPrecio; }
    public List<DtoPrecio> ejecutar(Long idTipoHabitacion) { return this.daoPrecio.listarPorIdTipoHabitacion(idTipoHabitacion); }
}
