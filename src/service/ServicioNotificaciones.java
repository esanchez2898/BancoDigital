package service;

import model.Cliente;

/* El patrón que estás viendo se llama Inyección de Dependencias (Dependency Injection) ????

Creamos una implementación específica (Ejemplo de la clase que usa 'implements'), INotificacion notificadorEmail = new NotificacionEmail();
Inyectamos esa implementación en el servicio coordinador. ServicioNotificaciones servicio = new ServicioNotificaciones(notificadorEmail);
El servicio coordinador usa el metodo 'enviar' de la clase inyectada. servicio.notificar("Su pedido ha sido enviado", unCliente);  */

public class ServicioNotificaciones {
    private final INotificacion implementacion;

    public ServicioNotificaciones(INotificacion implementacion) {
        this.implementacion = implementacion;
    }

    public void notificar(String mensaje, Cliente cliente) {
        implementacion.enviar(mensaje, cliente);
    }
}