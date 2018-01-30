package slz.blog.usuario.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import slz.blog.global.utils.BlogConstants;

@Component
public class UsuarioModel {

	private long idUsuario;
	@NotEmpty(message= "El campo nombre " + BlogConstants.ERROR_CAMPO_VACIO)
	private String nombre;
	@NotEmpty(message= "El campo password " + BlogConstants.ERROR_CAMPO_VACIO)
	private String password;
	
	
	public long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
