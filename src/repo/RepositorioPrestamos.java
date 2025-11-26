package repo;

import model.Prestamo;
import java.util.*;


public class RepositorioPrestamos implements IRepositorio<Prestamo> {
    private final Map<String, Prestamo> storage = new HashMap<>();


    @Override
    public Prestamo guardar(Prestamo entidad) {
        storage.put(entidad.getId(), entidad);
        return entidad;
    }


    @Override
    public Prestamo buscarPorId(String id) {
        return storage.get(id);
    }


    @Override
    public List<Prestamo> listar() {
        return new ArrayList<>(storage.values());
    }


    @Override
    public void eliminar(String id) {
        storage.remove(id);
    }
}