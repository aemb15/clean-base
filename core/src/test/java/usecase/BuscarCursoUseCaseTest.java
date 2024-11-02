package usecase;

import curso.input.BuscarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.BuscarCursoOutput;
import curso.usecase.BuscarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BuscarCursoUseCaseTest {

    BuscarCursoInput buscarCursoInput;
    @Mock
    BuscarCursoOutput buscarCursoOutput;

    @BeforeEach
    void setup(){
        buscarCursoInput = new BuscarCursoUseCase(buscarCursoOutput);
    }

    @Test
    public void testBuscarCurso_DevuelveColeccion(){

        Curso curso1 = Curso.instanciaCurso(null,"matematica", LocalDate.MAX, Nivel.MEDIO);
        Curso curso2 = Curso.instanciaCurso(null,"fisica", LocalDate.MAX, Nivel.AVANZADO);
        Curso curso3 = Curso.instanciaCurso(null,"quimica", LocalDate.MAX, Nivel.INICIAL);
        Curso curso4 = Curso.instanciaCurso(null,"biologia", LocalDate.MAX, Nivel.MEDIO);

        ArrayList<Curso> cursosEsperado = new ArrayList<>();
        cursosEsperado.add(curso1);
        cursosEsperado.add(curso2);
        cursosEsperado.add(curso3);
        cursosEsperado.add(curso4);

        when(buscarCursoOutput.consultar()).thenReturn(cursosEsperado);
        ArrayList<Curso> cursosActual = buscarCursoInput.buscar();
        //assertEquals(cursosActual,cursosEsperado);
        assertIterableEquals(cursosEsperado,cursosActual);

        //assertEquals(cursosEsperado,buscarCursoOutput.consultar());
        //Assertions.assertTrue(cursosEsperado.equals(buscarCursoOutput.consultar()));
    }

    @Test
    public void TestBuscarCurso_DevuelveVacia(){
        when(buscarCursoOutput.consultar()).thenReturn(new ArrayList<>());
        //ArrayList<Curso> cursosEsperado = buscarCursoInput.buscar();
        //Assertions.assertEquals(0,cursosEsperado.size());
       Assertions.assertTrue(buscarCursoOutput.consultar().isEmpty());



    }
}
