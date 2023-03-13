package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades.Ciudad;
import co.edu.uniquindio.proyecto.entidades.GeneroPersona;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    public void registrarUsuarioTest() {

        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","3225546588");
        telefonos.put("celular","3136118641");

        Usuario usuario = new Usuario("123","Juanita",LocalDate.now(),GeneroPersona.MASCULINO,"juana@mail.com",telefonos,ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);
        System.out.println(usuarioGuardado);
        Assertions.assertNotNull(usuarioGuardado);

    }

    @Test
    public void eliminarUsuarioTest() {

        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","3225546588");
        telefonos.put("celular","3136118641");

        Usuario usuario = new Usuario("123","Juanita",LocalDate.now(),GeneroPersona.MASCULINO,"juana@mail.com",telefonos,ciudad);

        Usuario usuarioGuarado = usuarioRepo.save(usuario);
        //Luego lo eliminamos
        usuarioRepo.delete(usuarioGuarado);

        //Por último, verificamos que si haya quedado borrado
        Usuario buscado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertNull(buscado);
    }

    @Test
    public void actualizarUsuarioTest() {

        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","3225546588");
        telefonos.put("celular","3136118641");

        Usuario usuario = new Usuario("123","Juanita",LocalDate.now(),GeneroPersona.MASCULINO,"juana@mail.com",telefonos,ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        //Modificamos el nombre
        usuarioGuardado.setNombre("Juanita Lopez");

        //Con save guardamos el registro modificado
        usuarioRepo.save(usuarioGuardado);
        //Por último, verificamos que si haya quedado actualizado
        Usuario buscado = usuarioRepo.findById("123").orElse(null);
        Assertions.assertEquals("Juanita Lopez", buscado.getNombre());

    }

    @Test
    public void listarUsuariosTest(){

        Ciudad ciudad = new Ciudad("Armenia");
        ciudadRepo.save(ciudad);

        Map<String,String> telefonos = new HashMap<>();
        telefonos.put("casa","3225546588");
        telefonos.put("celular","3136118641");

        Usuario usuario = new Usuario("123","Juanita",LocalDate.now(),GeneroPersona.MASCULINO,"juana@mail.com",telefonos,ciudad);

        Usuario usuarioGuardado = usuarioRepo.save(usuario);

        //Obtenemos la lista de todos los usuarios
        List<Usuario> usuarios = usuarioRepo.findAll();
        Assertions.assertEquals(1,usuarios.size());
        //Imprimimos la lista
        System.out.println(usuarios);
    }

    @Test
    @Sql("classpath:usuarios.sql")
    public void listarUsuariosTest2(){
        List<Usuario> usuarios = usuarioRepo.findAll();
        usuarios.forEach(usuario -> System.out.println(usuario));

    }
}
