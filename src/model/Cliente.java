package model;// Package: com.banco.model
// File: model.Cliente.java
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Representa un cliente del banco.
 */
public class Cliente {
    private String id;
    private String nombre;
    private String email;
    private List<Cuenta> cuentas = new ArrayList<>();
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();


    public Cliente(String nombre, String email) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.email = email;
    }


    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    public List<Cuenta> getCuentas() { return cuentas; }
    public List<Tarjeta> getTarjetas() { return tarjetas; }
    public List<Prestamo> getPrestamos() { return prestamos; }


    // Acciones de conveniencia
    public void abrirCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }


    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetas.add(tarjeta);
    }


    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
}