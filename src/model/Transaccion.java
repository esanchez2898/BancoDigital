package model;

import java.time.LocalDateTime;

public class Transaccion {
    private LocalDateTime fecha;
    private double monto;
    private TipoTransaccion tipo;
    private String descripcion;


    public Transaccion(double monto, TipoTransaccion tipo, String descripcion) {
        this.fecha = LocalDateTime.now();
        this.monto = monto;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }


    public LocalDateTime getFecha() { return fecha; }
    public double getMonto() { return monto; }
    public TipoTransaccion getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
}