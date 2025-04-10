package mx.unam.dgtic.modulo9_proyecto.service.impl;

import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.UsuarioDTO;
import mx.unam.dgtic.modulo9_proyecto.exception.UsuarioNotFound;
import mx.unam.dgtic.modulo9_proyecto.mapper.UsuarioMapper;
import mx.unam.dgtic.modulo9_proyecto.model.Usuario;
import mx.unam.dgtic.modulo9_proyecto.repository.UsuarioRepository;
import mx.unam.dgtic.modulo9_proyecto.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFound("Usuario no encontrado con el id" + id));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioNuevo = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioNuevo);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .map(u -> {
                    u.setNombreUsuario(usuarioDTO.getNombreUsuario());
                    u.setPassword(usuarioDTO.getPassword());
                    u.setEmail(usuarioDTO.getEmail());
                    return usuarioRepository.save(u);
                })
                .orElseThrow(() -> new UsuarioNotFound("Usuario no encontrado con el id" + id));

        return usuarioMapper.toDto(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFound("Usuario no encontrado con el id " + id));
        usuarioRepository.delete(usuario);
    }
}
