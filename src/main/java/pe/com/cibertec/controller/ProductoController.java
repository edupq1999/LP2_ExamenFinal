package pe.com.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.cibertec.entity.CategoriaEntity;
import pe.com.cibertec.entity.ProductoEntity;
import pe.com.cibertec.entity.UsuarioEntity;
import pe.com.cibertec.service.CategoriaService;
import pe.com.cibertec.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listaProductos")
    public String listarProductos(Model model) {
    	model.addAttribute("lstProductos", productoService.listarProductos());
        return "listaProductos";
    }
    
	@GetMapping("/crearProducto")
    public String crearProducto(Model model) {
    	model.addAttribute("newProducto", new UsuarioEntity());
		model.addAttribute("lstCategoria", categoriaService.listarCategoria());
        return "crearProducto";
    }
	
	@PostMapping("/crearProducto")
	public String registrarProducto(@RequestParam(value = "categoryId") Integer categoryId,
			@ModelAttribute("newProducto") ProductoEntity nuevoProducto) {
		if (categoryId != null) {
			CategoriaEntity categoria = categoriaService.buscarCategoriaPorId(categoryId);
			nuevoProducto.setCategoriaEntity(categoria);
			productoService.crearProducto(nuevoProducto);
		} else {
			System.out.println("No se seleccionó un área.");
		}
		return "listaProductos";
	}
    
    @GetMapping("/actualizar/{prodId}")
	public String mostrarFormularioActualizar(@PathVariable Integer prodId, Model model) {
		ProductoEntity producto = productoService.buscarPorId(prodId);
		List<CategoriaEntity> categorias = categoriaService.listarCategoria();
		model.addAttribute("producto", producto);
		model.addAttribute("lstCategorias", categorias);
		return "actualizarEmpleado";
	}

	@PostMapping("/actualizar/{prodId}")
	public String actualizarEmpleado(@PathVariable Integer prodId, @RequestParam Integer catId,
			@ModelAttribute("producto") ProductoEntity producto) {
		producto.setIdCategoria(catId);
		productoService.actualizarProducto(producto);
		return "listaProductos";
	}

	@GetMapping("/eliminar/{prodId}")
	public String eliminarEmpleado(@PathVariable("prodId") Integer prodId) {
		productoService.eliminarProducto(prodId);
		return "listaProductos";
	}
}
