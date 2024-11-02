package ar.edu.undec.adapter.service.rest;

import curso.input.BuscarCursoInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class BuscarCursoController {

    BuscarCursoInput buscarCursoInput;

    public BuscarCursoController(BuscarCursoInput buscarCursoInput) {
        this.buscarCursoInput = buscarCursoInput;
    }

    @GetMapping
    public ResponseEntity<?> buscarCurso() {
        try {
            return ResponseEntity.ok().body(buscarCursoInput.buscar());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
