package mx.unam.dgtic.modulo9_proyecto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Generación automática del id
    @Column(name = "id_pedido")
    private Long idPedido;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación con Usuario (un pedido pertenece a un usuario)
    @JoinColumn(name = "id_usuario", nullable = false)  // Columna que hace referencia a la tabla Usuario
    private Usuario usuario;

}
