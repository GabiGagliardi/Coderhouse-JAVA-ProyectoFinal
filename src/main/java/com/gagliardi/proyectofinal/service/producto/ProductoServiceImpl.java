package com.gagliardi.proyectofinal.service.producto;

import com.gagliardi.proyectofinal.entity.Producto;
import com.gagliardi.proyectofinal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService
{
    @Autowired
    private ProductoRepository productoRepository;
    //JpaRepository metodo listar, ordenar y eliminar. Revisar metodos con CTRL + Click sobre JpaRepository

    //########GET########
    //Metodo para mostrar Clientes
    @Override
    public List<Producto> mostrarProductos()
    {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id)
    {
        return productoRepository.findById(id).orElse(null);
    }

    //########POST########
    @Override
    public Producto crearProducto(Producto producto)
    {
        int tamanio = productoRepository.findAll().size();
        producto.setProductoid(tamanio+1);

        //Guardo el cliente con su id correcto y no repetido
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto)
    {
        return productoRepository.save(producto);
    }

    //Metodos Auxiliares
    @Override
    public Integer verificarProductoPorId(Integer id)
    {
        int flag=1;//error
        if(productoRepository.findById(id).orElse(null) != null)
        {
            flag=0;//Si el producto existe devulevo 0
        }

        return flag;
    }

    @Override
    public Integer verificarStockPorId(Integer id, Integer cantidad)
    {
        int flag=1;//error
        Producto producto = productoRepository.findById(id).orElse(null);
        if(cantidad <= producto.getStock())
        {
            flag = 0;//Si el stock alcanza devuelvo 0
        }

        return flag;

    }

    @Override
    public  String buscarNombrePorId(Integer id)
    {
        return productoRepository.findById(id).orElse(null).getNombre();
    }

    @Override
    public Float buscarPrecioPorId(Integer id)
    {
        return productoRepository.findById(id).orElse(null).getPrecio();
    }
}
