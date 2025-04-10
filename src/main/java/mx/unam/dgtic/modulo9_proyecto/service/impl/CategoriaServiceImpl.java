package mx.unam.dgtic.modulo9_proyecto.service.impl;

import lombok.RequiredArgsConstructor;
import mx.unam.dgtic.modulo9_proyecto.dto.CategoriaDTO;
import mx.unam.dgtic.modulo9_proyecto.exception.CategoriaNotFound;
import mx.unam.dgtic.modulo9_proyecto.mapper.CategoriaMapper;
import mx.unam.dgtic.modulo9_proyecto.model.Categoria;
import mx.unam.dgtic.modulo9_proyecto.repository.CategoriaRepository;
import mx.unam.dgtic.modulo9_proyecto.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Override
    public List<CategoriaDTO> obtenerCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO obtenerCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFound("Categoria no encontrada"));

        return categoriaMapper.toDto(categoria);
    }

    @Override
    public CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria categoriaNueva = categoriaRepository.save(categoria);
        return categoriaMapper.toDto(categoriaNueva);
    }

    @Override
    public CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .map(c -> {
                    c.setNombre(categoriaDTO.getNombre());
                    c.setDescripcion(categoriaDTO.getDescripcion());
                    return categoriaRepository.save(c);
                }).orElseThrow(() -> new CategoriaNotFound("Categoria no encontrada"));

        return categoriaMapper.toDto(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNotFound("Categoria no encontrada"));
        categoriaRepository.delete(categoria);

    }
}
