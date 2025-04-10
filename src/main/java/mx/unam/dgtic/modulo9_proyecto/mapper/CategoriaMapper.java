package mx.unam.dgtic.modulo9_proyecto.mapper;

import mx.unam.dgtic.modulo9_proyecto.dto.CategoriaDTO;
import mx.unam.dgtic.modulo9_proyecto.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaDTO toDto(Categoria categoria);

    Categoria toEntity(CategoriaDTO categoriaDTO);
}
