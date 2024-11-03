package ar.edu.undec.adapter.data.curso;

import ar.edu.undec.adapter.data.crud.BuscarCursosCRUD;
import ar.edu.undec.adapter.data.models.CursoDato;
import ar.edu.undec.adapter.data.repository.BuscarCursosRepository;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarCursoDatoTest {

    @Mock
    BuscarCursosCRUD buscarCursosCRUD;

    @InjectMocks
    BuscarCursosRepository buscarCursosRepository;

    @Test
    public void consultarCurso_ExistenCursos_DevuelveListaDeCursos() {
        CursoDato curso1 = new CursoDato(UUID.randomUUID(),"name", LocalDate.MAX, Nivel.INICIAL);
        CursoDato curso2 = new CursoDato(UUID.randomUUID(),"matematica", LocalDate.MAX, Nivel.MEDIO);
        CursoDato curso3 = new CursoDato(UUID.randomUUID(),"fisica", LocalDate.MAX, Nivel.AVANZADO);
        CursoDato curso4 = new CursoDato(UUID.randomUUID(),"quimica", LocalDate.MAX, Nivel.INICIAL);

        ArrayList<CursoDato> cursosEsperado = new ArrayList<>();
        cursosEsperado.add(curso1);
        cursosEsperado.add(curso2);
        cursosEsperado.add(curso3);
        cursosEsperado.add(curso4);

        when(buscarCursosCRUD.findAll()).thenReturn(cursosEsperado);
        ArrayList<Curso> cursosActual = buscarCursosRepository.consultar();
        assertEquals(cursosEsperado.size(),cursosActual.size());
    }


    @Test
    void consultarCurso_NoExisteCursos_DevuelveVacia(){
        when(buscarCursosCRUD.findAll()).thenReturn(new ArrayList<>());
        ArrayList<Curso> curso = buscarCursosRepository.consultar();
        assertEquals(0,curso.size());
    }

}
