import model.*;
import repo.*;
import service.*;
import exception.*;


import java.time.LocalDate;


public class DemoBanco {
    public static void main(String[] args) {
// Repositorios en memoria
        RepositorioClientes repoClientes = new RepositorioClientes();
        RepositorioCuentas repoCuentas = new RepositorioCuentas();
        RepositorioPrestamos repoPrestamos = new RepositorioPrestamos();


// Notificaciones (implementación simple: consola)
        INotificacion envioConsola = new INotificacion() {
            @Override
            public void enviar(String mensaje, Cliente cliente) {
                System.out.println("[NOTIFICACION] Para: " + cliente.getEmail() + " -> " + mensaje);
            }
        };


        ServicioNotificaciones servicioNotificaciones = new ServicioNotificaciones(envioConsola);


// Servicios
        ServicioClientes servicioClientes = new ServicioClientes(repoClientes, repoCuentas, servicioNotificaciones);
        ServicioCuentas servicioCuentas = new ServicioCuentas(repoCuentas);


// Flujo de ejemplo
        Cliente erick = servicioClientes.registrarCliente("Erick Sánchez", "erick@example.com");


        Cuenta ahorro = new CuentaAhorro(0.02);
        Cuenta corriente = new CuentaCorriente(500.0);


        servicioClientes.abrirCuentaParaCliente(erick.getId(), ahorro);
        servicioClientes.abrirCuentaParaCliente(erick.getId(), corriente);


// Operaciones
        servicioCuentas.depositar(ahorro.getNumero(), 1000.0);
        try {
            servicioCuentas.retirar(ahorro.getNumero(), 200.0);
        } catch (SaldoInsuficienteException e) {
            System.err.println("Error: " + e.getMessage());
        }


// Transferencia a cuenta corriente
        try {
            servicioCuentas.transferir(ahorro.getNumero(), corriente.getNumero(), 300.0);
        } catch (SaldoInsuficienteException e) {
            System.err.println("Error: " + e.getMessage());
        }


// Mostrar saldos
        System.out.println("Saldo ahorro: " + ahorro.getSaldo());
        System.out.println("Saldo corriente: " + corriente.getSaldo());


// Pagar con tarjeta débito (vinculada a cuenta corriente)
        TarjetaDebito td = new TarjetaDebito(erick, LocalDate.now().plusYears(3), corriente);
        erick.agregarTarjeta(td);


        try {
            td.pagar(100.0);
        } catch (Exception ex) {
            System.err.println("Pago con tarjeta fallido: " + ex.getMessage());
        }


        System.out.println("Saldo corriente después de pago con tarjeta: " + corriente.getSaldo());


// Crear y consultar préstamo
        Prestamo prestamo = new Prestamo(erick, 5000.0, 0.12, 24, TipoPrestamo.PERSONAL);
        repoPrestamos.guardar(prestamo);
        erick.agregarPrestamo(prestamo);


        System.out.println("Préstamo creado con saldo: " + prestamo.getSaldoRestante());


// Final
        System.out.println("Demo finalizada.");
    }
}