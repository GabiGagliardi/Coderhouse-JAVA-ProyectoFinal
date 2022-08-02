package com.gagliardi.proyectofinal.dto;

import com.gagliardi.proyectofinal.external.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

public class Fecha
{
    @Autowired
    private Rest rest;

    Date fechaActual()
    {
        Date fecha = new Date( System.currentTimeMillis() ); // Fecha calculada con JAVA

        if(rest.obtenerFechaRest() != null)
        {
            fecha = rest.obtenerFechaRest();
        }

        return fecha;
    }


}

