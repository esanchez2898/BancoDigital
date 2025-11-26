package service;

import model.Cliente;
import model.Cuenta;
import repo.RepositorioClientes;
import repo.RepositorioCuentas;
import exception.ClienteNoEncontradoException;


import java.time.LocalDate;


public class ServicioClientes {
    private final RepositorioClientes repoClientes;
    private final RepositorioCuentas repoCuentas;
    private final ServicioNotificaciones servicioNotificaciones;


    public ServicioClientes(RepositorioClientes repoClientes,
                            RepositorioCuentas repoCuentas,
                            ServicioNotificaciones servicioNotificaciones) {
        this.repoClientes = repoClientes;
        this.repoCuentas = repoCuentas;
        this.servicioNotificaciones = servicioNotificaciones;
    }


    public Cliente registrarCliente(String nombre, String email) {
        Cliente c = new Cliente(nombre, email);
        repoClientes.guardar(c);
        servicioNotificaciones.notificar("Bienvenido, " + nombre, c);
        return c;
    }


    public Cuenta abrirCuentaParaCliente(String clienteId, Cuenta cuenta) {
        Cliente c = repoClientes.buscarPorId(clienteId);
        if (c == null) throw new ClienteNoEncontradoException("Cliente no existe: " + clienteId);
        c.abrirCuenta(cuenta);
        repoClientes.guardar(c); // actualizar cliente
        repoCuentas.guardar(cuenta);
        servicioNotificaciones.notificar("Se ha abierto una nueva cuenta: " + cuenta.getNumero(), c);
        return cuenta;
    }
}