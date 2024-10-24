package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.entity.CategoriaEntity;

public interface CategoriaService {
	
	List<CategoriaEntity> listarCategoria();
	CategoriaEntity buscarCategoriaPorId(Integer categoriaId);
}
