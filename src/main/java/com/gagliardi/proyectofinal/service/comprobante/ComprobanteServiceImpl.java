package com.gagliardi.proyectofinal.service.comprobante;

import com.gagliardi.proyectofinal.entity.Comprobante;
import com.gagliardi.proyectofinal.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ComprobanteServiceImpl implements ComprobanteService
{
    @Autowired
    private ComprobanteRepository comprobanteRepository;

    //########GET########

    //Metodo para mostrar todos los comprobantes
    public List<Comprobante> mostrarComprobantes()
    {
        return comprobanteRepository.findAll();
    }

    public Comprobante buscarComprobantePorId(Integer id)
    {
        List<Comprobante> copiaComprobantes = comprobanteRepository.findAll();
        int tamanioLista = copiaComprobantes.size();
        int i = 0;//Contador

        for(i=0 ; i<tamanioLista ; i++)
        {
            if(id == copiaComprobantes.get(i).getComprobanteid())
            {
                return copiaComprobantes.get(i);
            }
        }

        return null;
    }

    //Metodos Auxiliares
    public Integer cantidadDeComprobantes()
    {
        return comprobanteRepository.findAll().size();
    }

    public void guardarComprobante(Comprobante comprobante)
    {
        comprobanteRepository.save(comprobante);
    }
}
