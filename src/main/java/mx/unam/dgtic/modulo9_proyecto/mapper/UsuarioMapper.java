package mx.unam.dgtic.modulo9_proyecto.mapper;

import mx.unam.dgtic.modulo9_proyecto.dto.UsuarioDTO;
import mx.unam.dgtic.modulo9_proyecto.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario usuario);

    Usuario toEntity(UsuarioDTO usuarioDTO);
}
