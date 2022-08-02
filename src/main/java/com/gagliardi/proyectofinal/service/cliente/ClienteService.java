package com.gagliardi.proyectofinal.service.cliente;

import com.gagliardi.proyectofinal.entity.Cliente;

import java.util.List;

public interface ClienteService
{
   //########GET########
   List<Cliente> mostrarClientes();

   Cliente buscarClientePorId(Integer id);

   Cliente buscarClientePorDni(Integer dni);

   //########POST########
   Cliente crearCliente(Cliente cliente);

   Cliente actualizarCliente(Cliente cliente);

   //Metodos Auxiliares
   Integer verificarClientePorId(Integer id);

}
