package ar.edu.undec.adapter.data.crud;

import ar.edu.undec.adapter.data.models.CursoDato;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RegistrarCursoCRUD extends CrudRepository<CursoDato, UUID> {

    boolean existsByNombre(String nombre);
}
