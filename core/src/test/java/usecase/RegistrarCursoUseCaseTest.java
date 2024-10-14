package usecase;

import curso.exception.ExisteCursoException;
import curso.input.RegistrarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.RegistrarCursoOutput;
import curso.usecase.RegistrarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoUseCaseTest {

    RegistrarCursoInput registrarCursoInput;
    @Mock
    RegistrarCursoOutput registrarCursoOutput;
    UUID uuid= UUID.randomUUID();

    @BeforeEach
    void setup() {
        registrarCursoInput = new RegistrarCursoUseCase(registrarCursoOutput);
    }

    @Test
    public void testRegistrarCurso() {
        Curso curso = Curso.instanciaCurso(null,"matematica", LocalDate.MAX, Nivel.MEDIO);
        when(registrarCursoOutput.existeCurso("matematica")).thenReturn(false);
        when(registrarCursoOutput.registrarCurso("matematica", LocalDate.MAX, Nivel.MEDIO)).thenReturn(uuid);
        UUID cursoRecibido = registrarCursoInput.registrarCurso("matematica", LocalDate.MAX, Nivel.MEDIO);
        Assertions.assertEquals(uuid,cursoRecibido);
    }

    @Test
    public void testRegistrarCurso_ExisteCurso() {
        Curso curso = Curso.instanciaCurso(null,"analisis", LocalDate.MAX, Nivel.MEDIO);
        when(registrarCursoOutput.existeCurso("analisis")).thenReturn(true);
        Assertions.assertThrows(ExisteCursoException.class,()->registrarCursoInput.registrarCurso("analisis",LocalDate.MAX, Nivel.MEDIO));
    }

    @Test
    public void testRegistrarCurso_NoSePudoGuardarCurso() {
        Curso curso = Curso.instanciaCurso(null,"fisica",LocalDate.MAX, Nivel.MEDIO);
        when(registrarCursoOutput.existeCurso("fisica")).thenReturn(false);
        UUID cursoRecibido = registrarCursoInput.registrarCurso("fisica", LocalDate.MAX, Nivel.MEDIO);
        assertNull(cursoRecibido);
        verify(registrarCursoOutput,times(1)).registrarCurso("fisica",LocalDate.MAX, Nivel.MEDIO);


    }

}
