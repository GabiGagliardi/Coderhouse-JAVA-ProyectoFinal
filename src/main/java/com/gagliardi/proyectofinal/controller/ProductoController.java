package com.gagliardi.proyectofinal.controller;

import com.gagliardi.proyectofinal.entity.Producto;
import com.gagliardi.proyectofinal.service.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyectofinal/productos")
public class ProductoController
{
    @Autowired//Para que la variable funcione
    private ProductoService productoService;

    //########GET########
    @GetMapping("")
    public List<Producto> mostrarTablaProductos()
    {
        return productoService.mostrarProductos();
    }

    @GetMapping("/{id}")
    public Producto mostrarProductoPorId(Integer id)
    {
        return productoService.buscarProductoPorId(id);
    }

    //########POST########
    @PostMapping("/crear")
    public Producto agregarProducto(Producto producto)
    {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/actualizar")
    public Producto renovarProducto(Producto producto)
    {
        return productoService.actualizarProducto(producto);
    }
}
