package com.gagliardi.proyectofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTOS")
//productoid int NOT NULL AUTO_INCREMENT,
//nombre VARCHAR(255) NOT NULL,
//stock int NOT NULL,
//precio FLOAT NOT NULL,
//PRIMARY KEY (productoid)

public class Producto
{
    @Id
    @Column(name="PRODUCTOID")
    private Integer productoid;

    @Column(name="NOMBRE")
    private String nombre;

    @Column(name="STOCK")
    private Integer stock;

    @Column(name="PRECIO")
    private Float precio;

    //Constructores
    public Producto() {}

    public Producto(Integer productoid, String nombre, Integer stock, Float precio) {
        this.productoid = productoid;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    //Getters and Setters

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
