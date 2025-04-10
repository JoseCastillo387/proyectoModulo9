package mx.unam.dgtic.modulo9_proyecto.repository;


import mx.unam.dgtic.modulo9_proyecto.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
