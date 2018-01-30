package slz.blog.categoria.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import slz.blog.global.utils.BlogConstants;

@Component
public class CategoriaModel {

	private long idCategoria;
	
	@NotEmpty(message= "El campo categoria " + BlogConstants.ERROR_CAMPO_VACIO)
	private String nombreCategoria;

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
}
