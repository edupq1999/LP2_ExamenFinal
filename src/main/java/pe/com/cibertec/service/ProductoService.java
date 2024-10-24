package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.entity.ProductoEntity;

public interface ProductoService {
	
	List<ProductoEntity> listarProductos();
	ProductoEntity buscarPorId(Integer idProducto);
	void crearProducto(ProductoEntity newProducto);
	void actualizarProducto(ProductoEntity updatedProducto);
	void eliminarProducto(Integer idProducto);
}
