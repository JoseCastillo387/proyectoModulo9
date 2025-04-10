package mx.unam.dgtic.modulo9_proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")  // Nombre de la tabla en la base de datos
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática del id
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(nullable = false, length = 255)  // Longitud máxima para la columna descripcion
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = true, length = 255)  // Longitud máxima para la columna imagen
    private String imagen;

    @Column(name = "nombre_producto", nullable = false, length = 100)  // Longitud máxima para la columna nombreProducto
    private String nombreProducto;

    @Column(nullable = false)  // Precio del producto no puede ser nulo
    private BigDecimal precio;

    @Column(nullable = false)  // El stock no puede ser nulo
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación con Categoria (muchos productos pueden tener una categoria)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)  // Columna que hace referencia a la tabla Categoria
    private Categoria categoria;
}
