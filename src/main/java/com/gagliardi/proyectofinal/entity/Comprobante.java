package com.gagliardi.proyectofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table (name="COMPROBANTES")
//comprobanteid INT NOT NULL AUTO_INCREMENT,
//fecha DATE NOT NULL,
//clienteid INT NOT NULL,
//productoid INT NOT NULL,
//producto VARCHAR(255) NOT NULL,
//precio FLOAT NOT NULL,
//cantidad  INT NOT NULL,
//total FLOAT NOT NULL,
//PRIMARY KEY (comprobanteid)

public class Comprobante
{
    @Id //Primary Key
    @Column(name = "COMPROBANTEID")
    private Integer comprobanteid;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "CLIENTEID")
    private Integer clienteid;

    @Column(name = "PRODUCTOID")
    private Integer productoid;

    @Column(name = "PRODUCTO")
    private String producto;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "TOTAL")
    private Float total;

    //Constructores

    public Comprobante() {}

    public Comprobante(Integer comprobanteid, Date fecha, Integer clienteid, Integer productoid, String producto, Float precio, Integer cantidad, Float total) {
        this.comprobanteid = comprobanteid;
        this.fecha = fecha;
        this.clienteid = clienteid;
        this.productoid = productoid;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    //Getters and Setters
    public Integer getComprobanteid() {
        return comprobanteid;
    }

    public void setComprobanteid(Integer comprobanteid) {
        this.comprobanteid = comprobanteid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
