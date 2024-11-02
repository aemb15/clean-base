package ar.edu.undec.adapter.service.rest;

import ar.edu.undec.adapter.service.domain.CursoDTO;
import curso.input.RegistrarCursoInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class RegistrarCursoController {

    RegistrarCursoInput registrarCursoInput;

    public RegistrarCursoController(RegistrarCursoInput registrarCursoInput) {
        this.registrarCursoInput = registrarCursoInput;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> registrarCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            return ResponseEntity.ok().body(registrarCursoInput.registrarCurso(cursoDTO.getNombre(),cursoDTO.getFecha(),cursoDTO.getNivel()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
