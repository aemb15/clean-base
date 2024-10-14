package curso.usecase;

import curso.exception.ExisteCursoException;

import curso.input.RegistrarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.RegistrarCursoOutput;

import java.time.LocalDate;
import java.util.UUID;


public class RegistrarCursoUseCase implements RegistrarCursoInput {

    private RegistrarCursoOutput registrarCursoOutput;

    public RegistrarCursoUseCase(RegistrarCursoOutput registrarCursoOutput) {
        this.registrarCursoOutput = registrarCursoOutput;
    }

    @Override
    public UUID registrarCurso(String nombre, LocalDate fecha, Nivel nivel) {
        if(registrarCursoOutput.existeCurso(nombre))
            throw new ExisteCursoException("El curso ya existe");
        Curso curso = Curso.instanciaCurso(null,nombre,fecha,nivel);
        return registrarCursoOutput.registrarCurso(curso);
    }

}
