package service;

import model.Cliente;


public class ServicioNotificaciones {
    private final INotificacion implementacion;


    public ServicioNotificaciones(INotificacion implementacion) {
        this.implementacion = implementacion;
    }


    public void notificar(String mensaje, Cliente cliente) {
        implementacion.enviar(mensaje, cliente);
    }
}