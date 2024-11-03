package ar.edu.undec.adapter.service.curso;

import ar.edu.undec.adapter.service.rest.BuscarCursoController;
import curso.input.BuscarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarCursoServiceTest {

    @Mock
    BuscarCursoInput buscarCursoInput;

    @InjectMocks
    BuscarCursoController buscarCursoController;

    @Test
    public void consultarCursos_ExistenCursos_Devuelve200(){
        Curso curso1 = Curso.instanciaCurso(null,"name", LocalDate.MAX, Nivel.INICIAL);
        Curso curso2 = Curso.instanciaCurso(null,"matematica", LocalDate.MAX, Nivel.MEDIO);
        Curso curso3 = Curso.instanciaCurso(null,"fisica", LocalDate.MAX, Nivel.AVANZADO);
        Curso curso4 = Curso.instanciaCurso(null,"quimica", LocalDate.MAX, Nivel.INICIAL);

        ArrayList<Curso> cursosEsperado = new ArrayList<>();
        cursosEsperado.add(curso1);
        cursosEsperado.add(curso2);
        cursosEsperado.add(curso3);
        cursosEsperado.add(curso4);

        when(buscarCursoInput.buscar()).thenReturn(cursosEsperado);
        ResponseEntity<?> resultado = buscarCursoController.buscarCurso();
        Assertions.assertEquals(HttpStatus.OK,resultado.getStatusCode());
    }

    @Test
    public void consultarCursos_NoExistenCursos_Devuelve204(){
        when(buscarCursoInput.buscar()).thenThrow(RuntimeException.class);
        ResponseEntity<?> resultado = buscarCursoController.buscarCurso();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,resultado.getStatusCode());
    }
}
