package com.gagliardi.proyectofinal.service.comprobante;

import com.gagliardi.proyectofinal.entity.Comprobante;

import java.util.List;

public interface ComprobanteService
{
    //########GET########
    List<Comprobante> mostrarComprobantes();

    Comprobante buscarComprobantePorId(Integer id);

    //Metodos Auxiliares
    void guardarComprobante(Comprobante comprobante);
    Integer cantidadDeComprobantes();

}
