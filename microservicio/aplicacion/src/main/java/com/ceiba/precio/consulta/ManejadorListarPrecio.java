package com.ceiba.precio.consulta;

import com.ceiba.precio.modelo.dto.DtoPrecio;
import com.ceiba.precio.puerto.dao.DaoPrecio;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPrecio {

    private final DaoPrecio daoPrecio;

    public ManejadorListarPrecio(DaoPrecio daoPrecio) { this.daoPrecio = daoPrecio; }
    public List<DtoPrecio> ejecutar() { return this.daoPrecio.listar(); }
}
