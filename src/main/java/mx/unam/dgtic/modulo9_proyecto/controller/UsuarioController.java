package mx.unam.dgtic.modulo9_proyecto.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.UsuarioDTO;
import mx.unam.dgtic.modulo9_proyecto.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuarios", description = "CRUD de usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista de todos los usuarios")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Lista de usuarios obtenida correctamente"),
            @ApiResponse (responseCode = "204", description = "No hay usuarios disponibles"),
    })
    @GetMapping("/")
    ResponseEntity<List<UsuarioDTO>> obtenerUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();
        return usuarios.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario específico por su ID")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Usuario encontrado"),
            @ApiResponse (responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable Long id){
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(summary = "Crear un nuevo usuario", description = "Crea un nuevo usuario en la base de datos")
    @ApiResponses({
            @ApiResponse (responseCode = "201", description = "Usuario creado correctamente"),
            @ApiResponse (responseCode = "400", description = "Datos invalidos")
    })
    @PostMapping("/")
    ResponseEntity<UsuarioDTO> crearUsuario(@Valid  @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioNuevo = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioNuevo);
    }

    @Operation(summary = "Actualizar un usuario", description = "Actualiza un usuario existente")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Usuario actualizado correctamente"),
            @ApiResponse (responseCode = "404", description = "Usuario no encontrado"),
            @ApiResponse (responseCode = "400", description = "Datos invalidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioActualizado = usuarioService.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @Operation(summary = "Eliminar un usuario", description = "Elimina un usuario existente por su ID")
    @ApiResponses({
            @ApiResponse (responseCode = "204", description = "Usuario eliminado correctamente"),
            @ApiResponse (responseCode = "404", description = "Usuario no encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
