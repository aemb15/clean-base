package curso.output;

import curso.modelo.Curso;
import java.util.UUID;

public interface RegistrarCursoOutput {

    UUID registrarCurso(Curso curso);
    boolean existeCurso(String nombre);
}
