package model;

import java.util.UUID;

public class Prestamo {


    private String id;
    private double monto;
    private double tasaInteres;
    private int meses;
    private double saldoRestante;
    private TipoPrestamo tipo;
    private Cliente cliente;


    public Prestamo(Cliente cliente, double monto, double tasaInteres, int meses, TipoPrestamo tipo) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.meses = meses;
        this.tipo = tipo;
        this.saldoRestante = monto; // simplificado: no amortizaciones iniciales
    }


    public String getId() { return id; }
    public double getMonto() { return monto; }
    public double getTasaInteres() { return tasaInteres; }
    public int getMeses() { return meses; }
    public double getSaldoRestante() { return saldoRestante; }
    public Cliente getCliente() { return cliente; }
    public TipoPrestamo getTipo() { return tipo; }


    public void pagarMensualidad(double montoPago) {
        if (montoPago <= 0) return;
        this.saldoRestante -= montoPago;
        if (this.saldoRestante < 0) this.saldoRestante = 0;
    }


    public double calcularInteresesTotales() {
        return this.monto * this.tasaInteres * (this.meses / 12.0);
    }
}