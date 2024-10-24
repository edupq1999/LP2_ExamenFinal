package pe.com.cibertec.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_producto")
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto", nullable = false)
	private Integer idProducto;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "precio", nullable = false)
	private Double precio;
	
	@Column(name = "fk_categoria", nullable = false)
    private Integer idCategoria;

	@ManyToOne
    @JoinColumn(name = "fk_categoria", referencedColumnName = "idCategoria", insertable = false, updatable = false)
    private CategoriaEntity categoriaEntity;

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public CategoriaEntity getCategoriaEntity() {
		return categoriaEntity;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
		this.categoriaEntity = categoriaEntity;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
