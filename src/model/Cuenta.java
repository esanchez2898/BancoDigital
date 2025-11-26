package model;

import exception.SaldoInsuficienteException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Clase abstracta que representa una cuenta bancaria básica.
 */
public abstract class Cuenta {
    protected String numero;
    protected double saldo;
    protected LocalDate fechaCreacion;
    protected List<Transaccion> historial = new ArrayList<>();


    public Cuenta() {
        this.numero = UUID.randomUUID().toString();
        this.fechaCreacion = LocalDate.now();
        this.saldo = 0.0;
    }


    // Getters
    public String getNumero() { return numero; }
    public double getSaldo() { return saldo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public List<Transaccion> getHistorial() { return historial; }


    // Operaciones abstractas
    public abstract void depositar(double monto);
    public abstract void retirar(double monto) throws SaldoInsuficienteException;


    /**
     * Transferencia por defecto usando retirar en origen y depositar en destino.
     */
    public void transferir(Cuenta destino, double monto) throws SaldoInsuficienteException {
        this.retirar(monto);
        destino.depositar(monto);
        this.historial.add(new Transaccion(monto, TipoTransaccion.TRANSFERENCIA, "Transferencia a " + destino.getNumero()));
        destino.getHistorial().add(new Transaccion(monto, TipoTransaccion.TRANSFERENCIA, "Transferencia desde " + this.getNumero()));
    }
}