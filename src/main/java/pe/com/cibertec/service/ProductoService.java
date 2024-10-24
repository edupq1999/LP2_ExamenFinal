package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.entity.ProductoEntity;

public interface ProductoService {
	
	List<ProductoEntity> listarProductos();
	ProductoEntity buscarPorId(Integer idProducto);
	boolean crearProducto(ProductoEntity newProducto);
	boolean actualizarProducto(ProductoEntity updatedProducto);
	boolean eliminarProducto(Integer idProducto);
}
