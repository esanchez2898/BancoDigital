package model;

import java.time.LocalDate;

public class TarjetaCredito extends Tarjeta {
    private double limite;
    private double saldoPendiente;


    public TarjetaCredito(Cliente propietario, LocalDate vigencia, double limite) {
        super(propietario, vigencia);
        this.limite = limite;
        this.saldoPendiente = 0.0;
    }


    public double getLimite() { return limite; }
    public double getSaldoPendiente() { return saldoPendiente; }


    @Override
    public void pagar(double monto) {
        if (!validarOperacion()) throw new IllegalStateException("model.Tarjeta vencida");
        if (monto + saldoPendiente > limite) throw new IllegalStateException("Límite de tarjeta excedido");
        saldoPendiente += monto;
// No asociamos transacción a cuenta; las liquidaciones harán el ajuste
    }


    public void liquidar(double monto) {
        if (monto > saldoPendiente) monto = saldoPendiente;
        saldoPendiente -= monto;
    }
}