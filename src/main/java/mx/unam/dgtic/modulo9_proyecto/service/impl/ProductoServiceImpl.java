package mx.unam.dgtic.modulo9_proyecto.service.impl;

import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.ProductoDTO;
import mx.unam.dgtic.modulo9_proyecto.exception.CategoriaNotFound;
import mx.unam.dgtic.modulo9_proyecto.exception.ProductoNotFound;
import mx.unam.dgtic.modulo9_proyecto.mapper.ProductoMapper;
import mx.unam.dgtic.modulo9_proyecto.model.Categoria;
import mx.unam.dgtic.modulo9_proyecto.model.Producto;
import mx.unam.dgtic.modulo9_proyecto.repository.CategoriaRepository;
import mx.unam.dgtic.modulo9_proyecto.repository.ProductoRepository;
import mx.unam.dgtic.modulo9_proyecto.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoDTO> obtenerProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFound("Producto no encontrado con el id " + id));
        return productoMapper.toDto(producto);
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepository.findById(productoDTO.getIdCategoria())
                .orElseThrow(() -> new CategoriaNotFound("Categoria no encontrada"));

        Producto producto = productoMapper.toEntity(productoDTO);
        producto.setCategoria(categoria);

        Producto productoNuevo = productoRepository.save(producto);

        return productoMapper.toDto(productoNuevo);

    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Categoria categoria = categoriaRepository.findById(productoDTO.getIdCategoria())
                .orElseThrow(() -> new CategoriaNotFound("Categoria no encontrada"));

        Producto producto = productoRepository.findById(id)
                .map(p -> {
                    p.setNombreProducto(productoDTO.getNombreProducto());
                    p.setDescripcion(productoDTO.getDescripcion());
                    p.setPrecio(productoDTO.getPrecio());
                    p.setStock(productoDTO.getStock());
                    p.setImagen(productoDTO.getImagen());
                    p.setCategoria(categoria);
                    return productoRepository.save(p);
                }).orElseThrow(() -> new ProductoNotFound("Producto no encontrado con el id " + id));

        return productoMapper.toDto(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFound("Producto no encontrado con el id " + id));
        productoRepository.delete(producto);
    }


}
