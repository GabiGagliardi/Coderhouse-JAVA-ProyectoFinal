package com.gagliardi.proyectofinal.controller;

import com.gagliardi.proyectofinal.entity.Comprobante;
import com.gagliardi.proyectofinal.service.comprobante.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("proyectofinal/comprobantes")
public class ComprobanteController
{
    @Autowired//Para que la variable funcione
    private ComprobanteService comprobanteService;

    //########GET########
    @GetMapping("")
    public List<Comprobante> mostrarTablaComprobantes() {
        return comprobanteService.mostrarComprobantes();
    }

    @GetMapping("/{id}")
    public Comprobante mostrarComoprobantePorId(@PathVariable Integer id)
    {
        return comprobanteService.buscarComprobantePorId(id);
    }
}
