package co.edu.uniquindio.proyecto.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario extends Persona implements Serializable {

    @Column(length =120 ,nullable = false,unique = true )
    private String email;
    @ElementCollection
    @Column(nullable = false)
    private Map<String, String> telefono;
    @ManyToOne
    private Ciudad ciudad;
    @OneToMany(mappedBy = "usuarioPrestamo")
    private List<Prestamo> prestamos;

}