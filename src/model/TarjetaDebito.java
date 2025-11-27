package model;

import exception.SaldoInsuficienteException;

import java.time.LocalDate;

public class TarjetaDebito extends Tarjeta {
    private Cuenta cuentaAsociada;


    public TarjetaDebito(Cliente propietario, LocalDate vigencia, Cuenta cuentaAsociada) {
        super(propietario, vigencia);
        this.cuentaAsociada = cuentaAsociada;
    }


    public Cuenta getCuentaAsociada() { return cuentaAsociada; }


    @Override
    public void pagar(double monto) throws SaldoInsuficienteException {
        if (!validarOperacion()) {
            throw new IllegalStateException("model.Tarjeta vencida");
        }
        cuentaAsociada.retirar(monto);
        cuentaAsociada.getHistorial().add(new Transaccion(monto, TipoTransaccion.PAGO, "Pago con tarjeta débito"));
    }
}