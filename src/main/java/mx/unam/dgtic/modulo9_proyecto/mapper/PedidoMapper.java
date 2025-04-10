package mx.unam.dgtic.modulo9_proyecto.mapper;

import mx.unam.dgtic.modulo9_proyecto.dto.PedidoDTO;
import mx.unam.dgtic.modulo9_proyecto.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    PedidoDTO toDto(Pedido pedido);

    @Mapping(source = "idUsuario", target = "usuario.idUsuario")
    Pedido toEntity(PedidoDTO pedidoDTO);

}
