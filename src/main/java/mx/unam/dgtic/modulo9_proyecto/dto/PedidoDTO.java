package mx.unam.dgtic.modulo9_proyecto.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long idPedido;
    private LocalDateTime fecha = LocalDateTime.now();
    @NotNull(message = "El total no puede ser nulo")
    private Double total;
    @NotNull(message = "El id del usuario no puede ser nulo")
    private Long idUsuario;

}
