package mx.unam.dgtic.modulo9_proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")  // Nombre de la tabla en la base de datos
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática del id
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(nullable = false, length = 255)  // Longitud máxima para la columna
    private String descripcion;

    @Column(nullable = false, length = 100)  // Longitud máxima para la columna
    private String nombre;

}
