package model;

import exception.SaldoInsuficienteException;

public class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;


    public CuentaCorriente(double limiteSobregiro) {
        super();
        this.limiteSobregiro = limiteSobregiro;
    }


    public double getLimiteSobregiro() { return limiteSobregiro; }
    public void setLimiteSobregiro(double limiteSobregiro) { this.limiteSobregiro = limiteSobregiro; }


    @Override
    public void depositar(double monto) {
        this.saldo += monto;
        this.historial.add(new Transaccion(monto, TipoTransaccion.DEPOSITO, "Depósito en cuenta corriente"));
    }


    @Override
    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto > this.saldo + this.limiteSobregiro) {
            throw new SaldoInsuficienteException("Saldo + límite de sobregiro insuficiente en cuenta corriente");
        }
        this.saldo -= monto;
        this.historial.add(new Transaccion(monto, TipoTransaccion.RETIRO, "Retiro en cuenta corriente"));
    }
}