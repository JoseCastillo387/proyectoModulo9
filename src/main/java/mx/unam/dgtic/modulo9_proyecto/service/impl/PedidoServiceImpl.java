package mx.unam.dgtic.modulo9_proyecto.service.impl;

import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.PedidoDTO;
import mx.unam.dgtic.modulo9_proyecto.exception.PedidoNotFound;
import mx.unam.dgtic.modulo9_proyecto.exception.UsuarioNotFound;
import mx.unam.dgtic.modulo9_proyecto.mapper.PedidoMapper;
import mx.unam.dgtic.modulo9_proyecto.model.Pedido;
import mx.unam.dgtic.modulo9_proyecto.model.Usuario;
import mx.unam.dgtic.modulo9_proyecto.repository.PedidoRepository;
import mx.unam.dgtic.modulo9_proyecto.repository.UsuarioRepository;
import mx.unam.dgtic.modulo9_proyecto.service.PedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final PedidoMapper pedidoMapper;

    @Override
    public List<PedidoDTO> obtenerPedidos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO obtenerPedidoPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFound("Pedido no encontrado con el id " + id));
        return pedidoMapper.toDto(pedido);
    }

    @Override
    public PedidoDTO crearPedido(PedidoDTO pedidoDTO) {
        Usuario usuario = usuarioRepository.findById(pedidoDTO.getIdUsuario())
                .orElseThrow(() -> new UsuarioNotFound("Usuario no encontrado con el id" + pedidoDTO.getIdUsuario()));

        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido.setUsuario(usuario);

        Pedido pedidoNuevo = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedidoNuevo);
    }

    @Override
    public PedidoDTO actualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Usuario usuario = usuarioRepository.findById(pedidoDTO.getIdUsuario())
                .orElseThrow(() -> new UsuarioNotFound("Usuario no encontrado"));

        Pedido pedido = pedidoRepository.findById(id)
                .map(p -> {
                    p.setTotal(pedidoDTO.getTotal());
                    p.setUsuario(usuario);
                    return pedidoRepository.save(p);
                }).orElseThrow(() -> new PedidoNotFound("Pedido no encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFound("Pedido no encontrado"));
        pedidoRepository.delete(pedido);
    }
}
