package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
@ToString
public class Persona implements Serializable {

    @Id
    @Column(length = 15)
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroPersona genero;



}
