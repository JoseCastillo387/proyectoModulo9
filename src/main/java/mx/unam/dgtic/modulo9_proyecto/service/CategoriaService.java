package mx.unam.dgtic.modulo9_proyecto.service;

import mx.unam.dgtic.modulo9_proyecto.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDTO> obtenerCategorias();

    CategoriaDTO obtenerCategoriaPorId(Long id);

    CategoriaDTO crearCategoria(CategoriaDTO categoriaDTO);

    CategoriaDTO actualizarCategoria(Long id, CategoriaDTO categoriaDTO);

    void eliminarCategoria(Long id);

}
