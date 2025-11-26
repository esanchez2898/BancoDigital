package service;

import model.Cuenta;
import repo.RepositorioCuentas;
import exception.CuentaNoEncontradaException;
import exception.SaldoInsuficienteException;


import java.util.List;


public class ServicioCuentas {
    private final RepositorioCuentas repoCuentas;


    public ServicioCuentas(RepositorioCuentas repoCuentas) {
        this.repoCuentas = repoCuentas;
    }


    public void depositar(String numeroCuenta, double monto) {
        Cuenta c = repoCuentas.buscarPorId(numeroCuenta);
        if (c == null) throw new CuentaNoEncontradaException("Cuenta no encontrada: " + numeroCuenta);
        c.depositar(monto);
        repoCuentas.guardar(c);
    }


    public void retirar(String numeroCuenta, double monto) throws SaldoInsuficienteException {
        Cuenta c = repoCuentas.buscarPorId(numeroCuenta);
        if (c == null) throw new CuentaNoEncontradaException("Cuenta no encontrada: " + numeroCuenta);
        c.retirar(monto);
        repoCuentas.guardar(c);
    }


    public void transferir(String origen, String destino, double monto) throws SaldoInsuficienteException {
        Cuenta cOrigen = repoCuentas.buscarPorId(origen);
        Cuenta cDestino = repoCuentas.buscarPorId(destino);
        if (cOrigen == null) throw new CuentaNoEncontradaException("Cuenta origen no encontrada: " + origen);
        if (cDestino == null) throw new CuentaNoEncontradaException("Cuenta destino no encontrada: " + destino);
        cOrigen.transferir(cDestino, monto);
        repoCuentas.guardar(cOrigen);
        repoCuentas.guardar(cDestino);
    }


    public List<Cuenta> listarCuentas() { return repoCuentas.listar(); }
}