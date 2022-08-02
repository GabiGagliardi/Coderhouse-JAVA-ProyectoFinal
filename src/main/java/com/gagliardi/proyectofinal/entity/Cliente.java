package com.gagliardi.proyectofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="CLIENTES")
//clienteid int NOT NULL AUTO_INCREMENT,
//dni int NOT NULL,
//nombre varchar(255) NOT NULL,
//apellido varchar(255),
//PRIMARY KEY (clienteid)

public class Cliente
{
    @Id
    @Column(name ="CLIENTEID")
    private Integer clienteid;

    @Column(name ="DNI")
    private Integer dni;

    @Column(name ="NOMBRE")
    private String nombre;

    @Column(name ="APELLIDO")
    private String apellido;

    //Constructores

    public Cliente() {}

    public Cliente(Integer clienteid, Integer dni, String nombre, String apellido) {
        this.clienteid = clienteid;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters and Setters

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
