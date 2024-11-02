package ar.edu.undec.adapter.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Nivel;

import java.time.LocalDate;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CursoDTO {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("fecha")
    private LocalDate fecha;
    @JsonProperty("nivel")
    private Nivel nivel;

    public CursoDTO() {
    }


    public CursoDTO(UUID id, String nombre, LocalDate fecha, Nivel nivel) {
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
}
