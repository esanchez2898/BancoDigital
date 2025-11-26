package repo;

import model.Cliente;
import java.util.*;


public class RepositorioClientes implements IRepositorio<Cliente> {
    private final Map<String, Cliente> storage = new HashMap<>();


    @Override
    public Cliente guardar(Cliente entidad) {
        storage.put(entidad.getId(), entidad);
        return entidad;
    }


    @Override
    public Cliente buscarPorId(String id) {
        return storage.get(id);
    }


    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(storage.values());
    }


    @Override
    public void eliminar(String id) {
        storage.remove(id);
    }
}