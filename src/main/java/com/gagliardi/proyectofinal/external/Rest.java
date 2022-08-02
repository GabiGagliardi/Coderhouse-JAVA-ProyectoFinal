package com.gagliardi.proyectofinal.external;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Rest
{
    public Date obtenerFechaRest()
    {
        Date fecha = null;
        List<String> data = null;
        SimpleDateFormat formato = new SimpleDateFormat("AAAA-MM-DDT00:00Z"); //Creo un nuevo formato de fecha
        RestTemplate restTemplate = new RestTemplate();

        final String url = "http://worldclockapi.com/api/json/utc/now";
        data= restTemplate.getForObject(url, List.class); //guardo el contendio de la url en la lista
        //{"$id":"1",
        //"currentDateTime":"2022-08-02T00:34Z",    Fecha en posicion 1 de la lista
        //"utcOffset":"00:00:00",
        //"isDayLightSavingsTime":false,
        //"dayOfTheWeek":"Tuesday",
        //"timeZoneName":"UTC",
        //"currentFileTime":133038740989237847,
        //"ordinalDate":"2022-214",
        //"serviceResponse":null}

        try {
                fecha = formato.parse( data.get(1) );
            }
            catch (ParseException e)
                {
                    throw new RuntimeException(e);
                }

        return fecha;
    }

}
