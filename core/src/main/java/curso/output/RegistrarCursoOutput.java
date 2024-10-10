package curso.output;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDate;
import java.util.UUID;

public interface RegistrarCursoOutput {
    UUID registrarCurso(String nombre, LocalDate fecha, Nivel nivel);
    //UUID registrarCurso(Curso curso);
    boolean existeCurso(String nombre);
}
