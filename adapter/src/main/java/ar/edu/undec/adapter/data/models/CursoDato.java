package ar.edu.undec.adapter.data.models;

import curso.modelo.Curso;
import curso.modelo.Nivel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "curso")
public class CursoDato {

    @Id
    private UUID id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "plazo_inscripcion")
    private LocalDate fecha;
    @Column(name = "nivel")
    private Nivel nivel;

    public CursoDato() {
    }

    public CursoDato(UUID id, String nombre, LocalDate fecha, Nivel nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivel = nivel;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public static CursoDato fromDomain(Curso curso){
        return new CursoDato(curso.getId(), curso.getNombre(),curso.getFecha(),curso.getNivel());
    }
}
