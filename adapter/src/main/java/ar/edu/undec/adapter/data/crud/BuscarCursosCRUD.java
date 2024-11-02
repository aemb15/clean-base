package ar.edu.undec.adapter.data.crud;

import ar.edu.undec.adapter.data.models.CursoDato;
import curso.modelo.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface BuscarCursosCRUD extends CrudRepository<CursoDato, UUID> {

    ArrayList<CursoDato> findAll();
}
