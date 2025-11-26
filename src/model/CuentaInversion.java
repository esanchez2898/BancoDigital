package model;

import exception.SaldoInsuficienteException;

public class CuentaInversion extends Cuenta {
    private double rendimientoAnual;


    public CuentaInversion(double rendimientoAnual) {
        super();
        this.rendimientoAnual = rendimientoAnual;
    }


    public double getRendimientoAnual() { return rendimientoAnual; }
    public void setRendimientoAnual(double rendimientoAnual) { this.rendimientoAnual = rendimientoAnual; }


    @Override
    public void depositar(double monto) {
        this.saldo += monto;
        this.historial.add(new Transaccion(monto, TipoTransaccion.DEPOSITO, "Depósito en cuenta de inversión"));
    }


    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente en cuenta de inversión");
        }
// Penalización sencilla por retiro anticipado: 1% del monto
        double penalizacion = monto * 0.01;
        this.saldo -= (monto + penalizacion);
        this.historial.add(new Transaccion(monto, TipoTransaccion.RETIRO, "Retiro en cuenta de inversión (penalización: " + penalizacion + ")"));
    }


    public void invertir(double monto) {
// Lógica simplificada: se usa depositar
        depositar(monto);
        this.historial.add(new Transaccion(monto, TipoTransaccion.DEPOSITO, "Inversión realizada"));
    }
}