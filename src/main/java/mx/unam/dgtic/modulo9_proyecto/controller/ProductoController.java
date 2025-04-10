package mx.unam.dgtic.modulo9_proyecto.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.ProductoDTO;
import mx.unam.dgtic.modulo9_proyecto.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/productos")
@Tag(name = "Producto", description = "CRUD para gestionar productos")
public class ProductoController {

    private final ProductoService productoService;

    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista de todos los productos")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Lista de productos obtenida correctamente"),
            @ApiResponse (responseCode = "204", description = "No hay productos disponibles")
    })
    @GetMapping("/")
    ResponseEntity<List<ProductoDTO>> obtenerProductos() {
        List<ProductoDTO> productos = productoService.obtenerProductos();
        return productos.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(productos);
    }

    @Operation(summary = "Obtener producto por ID", description = "Devuelve un producto específico por su ID")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Producto encontrado"),
            @ApiResponse (responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
    }

    @Operation(summary = "Crear un nuevo producto", description = "Crea un nuevo producto en la base de datos")
    @ApiResponses({
            @ApiResponse (responseCode = "201", description = "Producto creado correctamente"),
            @ApiResponse (responseCode = "400", description = "Datos invalidos")
    })
    @PostMapping("/")
    ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoNuevo = productoService.crearProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @Operation(summary = "Actualizar un producto", description = "Actualiza un producto existente")
    @ApiResponses({
            @ApiResponse (responseCode = "200", description = "Producto actualizado correctamente"),
            @ApiResponse (responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse (responseCode = "400", description = "Datos invalidos")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id, @Valid @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoActualizado = productoService.actualizarProducto(id, productoDTO);
        return ResponseEntity.ok(productoActualizado);
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto existente por su ID")
    @ApiResponses({
            @ApiResponse (responseCode = "204", description = "Producto eliminado correctamente"),
            @ApiResponse (responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
