package com.gagliardi.proyectofinal.service.cliente;

import com.gagliardi.proyectofinal.entity.Cliente;
import com.gagliardi.proyectofinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    //########GET########

    //Metodo para mostrar Clientes
    @Override
    public List<Cliente> mostrarClientes()
    {
        return clienteRepository.findAll();
    }

    //Metodo mostar cliente por ClienteID
    @Override
    public Cliente buscarClientePorId(Integer id)
    {
        return clienteRepository.findById(id).orElse(null);
    }

    //Metodo mostar cliente por DNI
    @Override
    public Cliente buscarClientePorDni(Integer dni)
    {
        List<Cliente> copiaClientes = clienteRepository.findAll();
        int tamanioLista = copiaClientes.size();
        int i = 0;//Contador

        for(i=0 ; i<tamanioLista ; i++)
        {
            if(dni == copiaClientes.get(i).getDni() )
            {
                return copiaClientes.get(i);
            }
        }

        return null;
    }

    //########POST########
    @Override
    public Cliente crearCliente(Cliente cliente)
    {
        List<Cliente> copiaClientes = clienteRepository.findAll();
        int tamanioLista = copiaClientes.size();
        int i = 0;//Contador
        Cliente error = new Cliente(0, 0, "DNI YA EXISTENTE", "INGRESAR DNI VALIDO");
        //Chequeo si el dni ingresado existe
        for (i = 0; i < tamanioLista ; i++) {
            if (cliente.getDni() == ( copiaClientes.get(i) ).getDni() ) //Comparo el dni nuevo con los dni de la lista
            {
                return error;
            }
        }

        //Si el dni no esta repetido guardo el cliente y lo devuelvo

        //Seteo el numero de id como el tamanio de la lista + 1
        cliente.setClienteid( tamanioLista + 1 );

        //Guardo el cliente con su id correcto y no repetido
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente)
    {
        return clienteRepository.save(cliente);
    }

    //Metodos Auxiliares
    @Override
    public Integer verificarClientePorId(Integer id)
    {
        int flag=1;//error
        if(clienteRepository.findById(id).orElse(null) != null)
        {
            flag=0;//Si el cliente existe devuelvo 0
        }

        return flag;

    }
}


