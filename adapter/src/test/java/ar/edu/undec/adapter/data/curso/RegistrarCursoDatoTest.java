package ar.edu.undec.adapter.data.curso;

import ar.edu.undec.adapter.data.crud.RegistrarCursoCRUD;
import ar.edu.undec.adapter.data.models.CursoDato;
import ar.edu.undec.adapter.data.repository.RegistrarCursoRepository;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoDatoTest {

    @Mock
    RegistrarCursoCRUD registrarCursoCRUD;

    @InjectMocks
    RegistrarCursoRepository registrarCursoRepository;

    @Test
    public void guardarCurso_CursoGuardado_Success(){
        Curso curso = Curso.instanciaCurso(UUID.randomUUID(),"name", LocalDate.MAX, Nivel.INICIAL);
        //when(registrarCursoCRUD.save(any(CursoDato.class))).thenReturn(new CursoDato());
        when(registrarCursoCRUD.save(any(CursoDato.class))).thenReturn(new CursoDato(UUID.randomUUID(),"name", LocalDate.MAX, Nivel.INICIAL));
        UUID resultado = registrarCursoRepository.registrarCurso(curso);
        //Assertions.assertTrue(resultado);
        Assertions.assertNotNull(resultado);
    }


    @Test
    public void guardarCurso_Exception_RetornaFalse(){
        Curso curso = Curso.instanciaCurso(UUID.randomUUID(),"name", LocalDate.MAX, Nivel.INICIAL);
        when(registrarCursoCRUD.save(any(CursoDato.class))).thenThrow(RuntimeException.class);
        UUID resultado = registrarCursoRepository.registrarCurso(curso);
        //Assertions.assertFalse(resultado);
        Assertions.assertNull(resultado);
    }
}
