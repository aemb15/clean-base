package ar.edu.undec.adapter.data.repository;

import ar.edu.undec.adapter.data.crud.BuscarCursosCRUD;
import ar.edu.undec.adapter.data.models.CursoDato;
import curso.modelo.Curso;
import curso.output.BuscarCursoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class BuscarCursosRepository implements BuscarCursoOutput {

    BuscarCursosCRUD buscarCursosCRUD;

    @Autowired
    public BuscarCursosRepository(BuscarCursosCRUD buscarCursosCRUD) {
        this.buscarCursosCRUD = buscarCursosCRUD;
    }

    @Override
    public ArrayList<Curso> consultar() {
        return buscarCursosCRUD.findAll().stream()
                .map(CursoDato::fromDomainn).collect(Collectors.toCollection(ArrayList::new));
    }
}
