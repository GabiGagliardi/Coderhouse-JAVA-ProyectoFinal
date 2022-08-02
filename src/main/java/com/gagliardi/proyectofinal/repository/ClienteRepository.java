package com.gagliardi.proyectofinal.repository;

import com.gagliardi.proyectofinal.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Integer> //<Clase,Tipo de archivo de Id>
{
}
