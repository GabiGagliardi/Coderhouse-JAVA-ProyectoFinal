package com.gagliardi.proyectofinal.repository;

import com.gagliardi.proyectofinal.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> //<Clase,Tipo de archivo de Id>
{
}
