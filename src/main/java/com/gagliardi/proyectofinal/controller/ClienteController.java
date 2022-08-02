package com.gagliardi.proyectofinal.controller;

import com.gagliardi.proyectofinal.entity.Cliente;
import com.gagliardi.proyectofinal.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proyectofinal/clientes")
public class ClienteController {
    @Autowired//Para que la variable funcione
    private ClienteService clienteService;

    //########GET########
    @GetMapping("")
    public List<Cliente> mostrarTablaClientes() {
        return clienteService.mostrarClientes();
    }

    @GetMapping("/{id}")
    public Cliente mostrarClientePorId(@PathVariable Integer id)
    {
        return clienteService.buscarClientePorId(id);
    }

    @GetMapping("/{dni}")
    public Cliente mostrarClientePorDni(@PathVariable Integer dni)
    {
        return clienteService.buscarClientePorDni(dni);
    }

    //########POST########
    @PostMapping("/crear")
    public Cliente agregarCliente(Cliente cliente)
    {
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/actualizar")
    public Cliente renovarCliente(Cliente cliente)
    {
        return clienteService.actualizarCliente(cliente);
    }

}
