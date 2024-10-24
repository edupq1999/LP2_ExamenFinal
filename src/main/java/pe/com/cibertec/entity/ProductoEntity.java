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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto", nullable = false)
	private Integer idProducto;
	
	@Column(name = "nombre", nullable = false)
	private Integer nombre;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "fk_categoria", nullable = false)
    private Integer idCategoria;

	@ManyToOne
    @JoinColumn(name = "fk_categoria", referencedColumnName = "idCategoria", insertable = false, updatable = false)
    private CategoriaEntity categoriaEntity;
}
