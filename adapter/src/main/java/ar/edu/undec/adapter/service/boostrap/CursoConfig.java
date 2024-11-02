package ar.edu.undec.adapter.service.boostrap;


import ar.edu.undec.adapter.data.repository.RegistrarCursoRepository;
import curso.input.BuscarCursoInput;
import curso.input.RegistrarCursoInput;
import curso.output.BuscarCursoOutput;
import curso.output.RegistrarCursoOutput;
import curso.usecase.BuscarCursoUseCase;
import curso.usecase.RegistrarCursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CursoConfig {

    @Bean
    public RegistrarCursoInput registrarCurso(RegistrarCursoOutput registrarCursoRepository) {
        return new RegistrarCursoUseCase(registrarCursoRepository);
    }

    @Bean
    public BuscarCursoInput buscarCursoInput(BuscarCursoOutput buscarCusosRepository) {
        return new BuscarCursoUseCase(buscarCusosRepository);
    }
}
