package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Ciudad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(length = 80,nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Usuario> usuarios;

    public Ciudad(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}


