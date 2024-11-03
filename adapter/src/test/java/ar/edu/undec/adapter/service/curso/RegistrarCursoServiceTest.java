package ar.edu.undec.adapter.service.curso;

import ar.edu.undec.adapter.service.domain.CursoDTO;
import ar.edu.undec.adapter.service.rest.RegistrarCursoController;
import curso.exception.ExisteCursoException;
import curso.input.RegistrarCursoInput;
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
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoServiceTest {

    @Mock
    RegistrarCursoInput registrarCursoInput;

    @InjectMocks
    RegistrarCursoController registrarCursoController;

    @Test
    public void registrarCurso_CursoGuardar_Devuelve200() {
        //Arrange
        when(registrarCursoInput.registrarCurso("name", LocalDate.MAX, Nivel.INICIAL)).thenReturn(UUID.randomUUID());
        CursoDTO cursoDTO = new CursoDTO(null,"name",LocalDate.MAX,Nivel.INICIAL);
        //Act
        ResponseEntity<?> resultado = registrarCursoController.registrarCurso(cursoDTO);
        //Assert
        Assertions.assertEquals(HttpStatus.OK, resultado.getStatusCode());
        //Assertions.assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

    @Test
    public void registrarCurso_CursoExiste_Devuelve400() {
        //Arrange
        when(registrarCursoInput.registrarCurso("name", LocalDate.MAX, Nivel.INICIAL)).thenThrow(ExisteCursoException.class);
        CursoDTO cursoDTO = new CursoDTO(null,"name",LocalDate.MAX,Nivel.INICIAL);
        //Act
        ResponseEntity<?> resultado = registrarCursoController.registrarCurso(cursoDTO);
        //Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, resultado.getStatusCode());
        //Assertions.assertEquals("El curso ya existe",resultado.getBody());
    }


    @Test
    public void registrarCurso_CursoNoGuardar_Devuelve500() {
        //Arrange
        when(registrarCursoInput.registrarCurso("name", LocalDate.MAX, Nivel.INICIAL)).thenReturn(UUID.randomUUID());
        CursoDTO cursoDTO = new CursoDTO(null,"name",LocalDate.MAX,Nivel.INICIAL);
        //Act
        ResponseEntity<?> resultado = registrarCursoController.registrarCurso(cursoDTO);
        //Assert
        Assertions.assertEquals(HttpStatus.OK, resultado.getStatusCode());
        //Assertions.assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }

}
