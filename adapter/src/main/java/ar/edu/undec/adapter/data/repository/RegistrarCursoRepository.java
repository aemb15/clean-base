package ar.edu.undec.adapter.data.repository;

import ar.edu.undec.adapter.data.crud.RegistrarCursoCRUD;
import ar.edu.undec.adapter.data.models.CursoDato;
import curso.modelo.Curso;
import curso.output.RegistrarCursoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public class RegistrarCursoRepository implements RegistrarCursoOutput {

    RegistrarCursoCRUD registrarCursoCRUD;

    @Autowired
    public RegistrarCursoRepository(RegistrarCursoCRUD registrarCursoCRUD) {
        this.registrarCursoCRUD = registrarCursoCRUD;
    }

    @Override
    public UUID registrarCurso(Curso curso){
        try {
            return registrarCursoCRUD.save(CursoDato.fromDomain(curso)).getId();
        } catch (RuntimeException e) {
            return null;
        }

    }

    @Override
    public boolean existeCurso(String nombre) {
        return registrarCursoCRUD.existsByNombre(nombre);
    }

}
