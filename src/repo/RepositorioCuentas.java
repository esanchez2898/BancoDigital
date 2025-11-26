package repo;

import model.Cuenta;
import java.util.*;


public class RepositorioCuentas implements IRepositorio<Cuenta> {
    private final Map<String, Cuenta> storage = new HashMap<>();


    @Override
    public Cuenta guardar(Cuenta entidad) {
        storage.put(entidad.getNumero(), entidad);
        return entidad;
    }


    @Override
    public Cuenta buscarPorId(String id) {
        return storage.get(id);
    }


    @Override
    public List<Cuenta> listar() {
        return new ArrayList<>(storage.values());
    }


    @Override
    public void eliminar(String id) {
        storage.remove(id);
    }
}