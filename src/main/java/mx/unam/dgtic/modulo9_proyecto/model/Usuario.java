package mx.unam.dgtic.modulo9_proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")  // Nombre de la tabla en la base de datos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática del id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, length = 255)  // Longitud máxima para la columna password
    private String password;

    @Column(nullable = false, unique = true, length = 255)  // El email debe ser único
    private String email;

    @Column(name = "fecha_creacion", nullable = false)  // Fecha de creación no puede ser nula
    private LocalDateTime fechaCreacion;

    @Column(name = "nombre_usuario", nullable = false, length = 100)  // Longitud máxima para la columna nombreUsuario
    private String nombreUsuario;
}
