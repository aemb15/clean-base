package curso.input;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarCursoInput {

    UUID registrarCurso(String nombre, LocalDate fecha, Nivel nivel);
    //UUID registrarCurso(Curso curso);
}
