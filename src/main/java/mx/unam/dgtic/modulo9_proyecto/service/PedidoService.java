package mx.unam.dgtic.modulo9_proyecto.service;

import mx.unam.dgtic.modulo9_proyecto.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {

    List<PedidoDTO> obtenerPedidos();

    PedidoDTO obtenerPedidoPorId(Long id);

    PedidoDTO crearPedido(PedidoDTO pedidoDTO);

    PedidoDTO actualizarPedido(Long id, PedidoDTO pedidoDTO);

    void eliminarPedido(Long id);
}
