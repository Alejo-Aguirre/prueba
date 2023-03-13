package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Autor extends Persona implements Serializable {

    @Max(9999)
    @Column(nullable = false)
    private Integer anioNacimiento;

    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor(String codigo, String nombre, LocalDate fechaNacimiento, GeneroPersona genero, Integer anioNacimiento, List<Libro> libros) {
        super(codigo, nombre, fechaNacimiento, genero);
        this.anioNacimiento = anioNacimiento;
        this.libros = libros;
    }
}
