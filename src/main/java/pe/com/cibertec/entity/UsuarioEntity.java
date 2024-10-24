package pe.com.cibertec.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor
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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fNacimiento;
	
	@Column(name = "url", nullable = false)
	private String url;

	public String getCorreo() {
		return correo;
	}

	public String getPassword() {
		return password;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public String getUrl() {
		return url;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
