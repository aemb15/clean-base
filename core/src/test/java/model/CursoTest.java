package model;

import curso.exception.CursoFechaNoValidaException;
import curso.exception.CursoNivelNoValidaException;
import curso.exception.CursoNombreNuloException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class CursoTest {

   @Test
    public void test01() {
        //UUID uuid= UUID.randomUUID();
        Curso miCurso = Curso.instanciaCurso(UUID.randomUUID(),"nombre",LocalDate.MAX,Nivel.MEDIO);
        Assertions.assertNotNull(miCurso);

    }

    @Test
    public void test02() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNombreNuloException.class, ()->Curso.instanciaCurso(UUID.randomUUID(),"",LocalDate.MAX,Nivel.MEDIO));
        Assertions.assertEquals("El nombre es invalido", excepcion.getMessage());
    }

    @Test
    public void test03() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNombreNuloException.class, ()->Curso.instanciaCurso(UUID.randomUUID(),null,LocalDate.MAX,Nivel.MEDIO));
        Assertions.assertEquals("El nombre es invalido", excepcion.getMessage());
    }

    @Test
    public void test04() {

        RuntimeException excepcion = Assertions.assertThrows(CursoFechaNoValidaException.class, ()->Curso.instanciaCurso(UUID.randomUUID(),"Carlos",LocalDate.MIN,Nivel.MEDIO));
        Assertions.assertEquals("La fecha no es valida", excepcion.getMessage());
    }

    @Test
    public void test05() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNivelNoValidaException.class, ()->Curso.instanciaCurso(UUID.randomUUID(),"Carlos",LocalDate.MAX,null));
        Assertions.assertEquals("El nivel es invalido", excepcion.getMessage());
    }
}
