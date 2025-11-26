package model;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Tarjeta {
    protected String numero;
    protected LocalDate vigencia;
    protected Cliente propietario;


    public Tarjeta(Cliente propietario, LocalDate vigencia) {
        this.numero = UUID.randomUUID().toString();
        this.propietario = propietario;
        this.vigencia = vigencia;
    }


    public String getNumero() { return numero; }
    public LocalDate getVigencia() { return vigencia; }
    public Cliente getPropietario() { return propietario; }


    public abstract void pagar(double monto) throws Exception;
    public boolean validarOperacion() {
        return LocalDate.now().isBefore(vigencia.plusDays(1));
    }
}