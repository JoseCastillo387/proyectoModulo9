package mx.unam.dgtic.modulo9_proyecto.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Long idCategoria;
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String nombre;

}
