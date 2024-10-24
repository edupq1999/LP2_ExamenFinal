package pe.com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.entity.CategoriaEntity;
import pe.com.cibertec.entity.ProductoEntity;
import pe.com.cibertec.repository.CategoriaRepository;
import pe.com.cibertec.repository.ProductoRepository;
import pe.com.cibertec.service.CategoriaService;
import pe.com.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements CategoriaService, ProductoService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<ProductoEntity> listarProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public ProductoEntity buscarPorId(Integer idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto).get();
	}

	@Override
	public boolean crearProducto(ProductoEntity newProducto) {
		// TODO Auto-generated method stub
		try {
			productoRepository.save(newProducto);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}

	@Override
	public boolean actualizarProducto(ProductoEntity updatedProducto) {
		// TODO Auto-generated method stub
		ProductoEntity producto = buscarPorId(updatedProducto.getIdProducto());
		if(producto != null) {
			productoRepository.save(updatedProducto);
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarProducto(Integer idProducto) {
		// TODO Auto-generated method stub
		ProductoEntity producto = buscarPorId(idProducto);
		if(producto != null) {
			productoRepository.delete(producto);
			return true;
		}
		return false;
	}

	@Override
	public List<CategoriaEntity> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public CategoriaEntity buscarCategoriaPorId(Integer categoriaId) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(categoriaId).get();
	}

}
