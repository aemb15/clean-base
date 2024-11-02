package ar.edu.undec.adapter.service.boostrap;

import ar.edu.undec.adapter.data.repository.RegistrarCursoRepository;
import curso.input.RegistrarCursoInput;
import curso.output.RegistrarCursoOutput;
import curso.usecase.RegistrarCursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoConfig {

    @Bean
    public RegistrarCursoInput registrarCurso(RegistrarCursoOutput registrarCursoRepository) {
        return new RegistrarCursoUseCase(registrarCursoRepository);
    }
}
