package mx.unam.dgtic.modulo9_proyecto.service;


import mx.unam.dgtic.modulo9_proyecto.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> obtenerUsuarios();

    UsuarioDTO obtenerUsuarioPorId(Long id);

    UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO);

    UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO);

    void eliminarUsuario(Long id);
}
