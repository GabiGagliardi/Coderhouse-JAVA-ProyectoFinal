package com.gagliardi.proyectofinal.repository;

import com.gagliardi.proyectofinal.entity.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepository extends JpaRepository <Comprobante,Integer> //<Clase,Tipo de archivo de Id>
{

}
