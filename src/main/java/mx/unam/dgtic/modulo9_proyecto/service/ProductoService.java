package mx.unam.dgtic.modulo9_proyecto.service;

import mx.unam.dgtic.modulo9_proyecto.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoDTO> obtenerProductos();

    ProductoDTO obtenerProductoPorId(Long id);

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);

    void eliminarProducto(Long id);
}
