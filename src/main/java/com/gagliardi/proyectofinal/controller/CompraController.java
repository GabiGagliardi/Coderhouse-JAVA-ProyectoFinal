package com.gagliardi.proyectofinal.controller;

import com.gagliardi.proyectofinal.dto.Compra;
import com.gagliardi.proyectofinal.entity.Comprobante;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyectofinal/comprar")
public class CompraController
{
    private Compra compra;

    //########POST########
    @PostMapping("/")
    public Comprobante realizarCompra (Compra datosCompra)
    {
        return compra.comprar(datosCompra);
    }
}
