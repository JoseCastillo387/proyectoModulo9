package mx.unam.dgtic.modulo9_proyecto.repository;



import mx.unam.dgtic.modulo9_proyecto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
