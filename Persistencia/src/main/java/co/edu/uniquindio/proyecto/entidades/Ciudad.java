package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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
    //@JoinColumn(nullable = false)
    private List<Usuario> usuarios;

    public Ciudad(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
}


