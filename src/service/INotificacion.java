package service;

import model.Cliente;


public interface INotificacion {
    void enviar(String mensaje, Cliente cliente);
}