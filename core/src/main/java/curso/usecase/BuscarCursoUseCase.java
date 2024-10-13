package curso.usecase;

import curso.input.BuscarCursoInput;
import curso.modelo.Curso;
import curso.output.BuscarCursoOutput;

import java.util.ArrayList;

public class BuscarCursoUseCase implements BuscarCursoInput {

    private BuscarCursoOutput buscarCursoOutput;

    public BuscarCursoUseCase(BuscarCursoOutput buscarCursoOutput) {
        this.buscarCursoOutput = buscarCursoOutput;
    }

    @Override
    public ArrayList<Curso> buscar() {
        return buscarCursoOutput.consultar();
    }
}
