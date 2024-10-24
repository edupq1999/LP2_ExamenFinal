package pe.com.cibertec.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {
	
	@Id
	@Column(name = "correo", nullable = false)
	private String correo;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@Column(name = "fNacimiento", nullable = false)
	private Date fNacimiento;
	
	@Column(name = "url", nullable = false)
	private String url;
}
