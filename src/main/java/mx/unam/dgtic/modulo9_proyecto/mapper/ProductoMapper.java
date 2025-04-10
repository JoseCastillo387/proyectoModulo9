package mx.unam.dgtic.modulo9_proyecto.mapper;

import mx.unam.dgtic.modulo9_proyecto.dto.ProductoDTO;
import mx.unam.dgtic.modulo9_proyecto.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    @Mapping(source = "categoria.idCategoria", target = "idCategoria")
    ProductoDTO toDto(Producto producto);

    @Mapping(source = "idCategoria", target = "categoria.idCategoria")
    Producto toEntity(ProductoDTO productoDTO);

}
