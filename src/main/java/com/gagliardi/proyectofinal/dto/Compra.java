package com.gagliardi.proyectofinal.dto;

import com.gagliardi.proyectofinal.entity.Comprobante;
import com.gagliardi.proyectofinal.entity.Producto;
import com.gagliardi.proyectofinal.service.cliente.ClienteService;
import com.gagliardi.proyectofinal.service.comprobante.ComprobanteService;
import com.gagliardi.proyectofinal.service.producto.ProductoService;


public class Compra
{
    private Integer clienteid;
    private Integer productoid;
    private Integer cantidad;

    //Constructores

    public Compra() {}

    public Compra(Integer clienteid, Integer productoid, Integer cantidad) {
        this.clienteid = clienteid;
        this.productoid = productoid;
        this.cantidad = cantidad;
    }

    //Getters and Setters
    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    //Metodo de compra
    public Comprobante comprar(Compra datosCompra)
    {
        ClienteService clienteService = null;
        ProductoService productoService = null;
        ComprobanteService comprobanteService = null;
        int verificarCliente=0;
        int verificarProducto=0;
        int verificarStock=0;
        Comprobante comprobante = new Comprobante();
        Comprobante mensajeError= new Comprobante();
        Fecha fecha = new Fecha();
        Producto productoComprado = new Producto();
        int stockInicial= 0;


        //Verifico si el cliente existe
        verificarCliente= clienteService.verificarClientePorId(datosCompra.getClienteid());//Si existe devuelve 0
        if (verificarCliente != 0)
        {
            mensajeError.setProducto("ERROR: CLIENTE NO EXISTE");
            return mensajeError;//Devuelvo ERROR
        }

        //Verifico si el producto existe
        verificarProducto= productoService.verificarProductoPorId(datosCompra.getProductoid()); //Si existe devuelve 0
        if(verificarProducto != 0)
        {
            mensajeError.setProducto("ERROR: PRODUCTO NO EXISTE");
            return mensajeError;//Devuelvo ERROR
        }

        //Verifico si el Stock alcanza
        verificarStock= productoService.verificarStockPorId( datosCompra.getProductoid() , datosCompra.getCantidad() );//Si alcanza devuelve 0
        if(verificarStock != 0)
        {
            mensajeError.setProducto("ERROR: STOCK NO ALCANZA");
            return mensajeError;//Devuelvo ERROR
        }

        //Modifico el Stock del producto comprado
        productoComprado = productoService.buscarProductoPorId(datosCompra.getProductoid()); //Copia del producto existente
        productoComprado.setStock( stockInicial - datosCompra.getCantidad() ); // Calculo y guardo el nuevo Stock
        productoService.actualizarProducto(productoComprado); //Actualizo el producto

        //Seteo todos los parametros del comprobante
        comprobante.setComprobanteid( comprobanteService.cantidadDeComprobantes() + 1 );
        comprobante.setFecha(fecha.fechaActual());
        comprobante.setClienteid( datosCompra.getClienteid() );
        comprobante.setProductoid( datosCompra.getProductoid() );
        comprobante.setProducto( productoService.buscarNombrePorId( datosCompra.getProductoid() )  );
        comprobante.setPrecio( productoService.buscarPrecioPorId( datosCompra.getProductoid() )  );
        comprobante.setCantidad( datosCompra.getCantidad() );
        comprobante.setTotal( comprobante.getPrecio() * comprobante.getCantidad() );

        comprobanteService.guardarComprobante(comprobante);

        return comprobante;

    }
}
