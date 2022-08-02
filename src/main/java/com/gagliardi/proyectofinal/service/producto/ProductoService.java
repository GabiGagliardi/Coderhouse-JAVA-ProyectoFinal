package com.gagliardi.proyectofinal.service.producto;

import com.gagliardi.proyectofinal.entity.Producto;

import java.util.List;

public interface ProductoService
{
    //########GET########
    List<Producto> mostrarProductos();

    Producto buscarProductoPorId(Integer id);

    //########POST########
    Producto crearProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    //Metodos Auxiliares
    Integer verificarProductoPorId(Integer id);
    Integer verificarStockPorId(Integer id, Integer cantidad);
    String buscarNombrePorId(Integer id);
    Float buscarPrecioPorId(Integer id);
}
