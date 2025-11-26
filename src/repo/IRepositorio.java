package repo;

import java.util.List;


public interface IRepositorio<T> {
    T guardar(T entidad);
    T buscarPorId(String id);
    List<T> listar();
    void eliminar(String id);
}