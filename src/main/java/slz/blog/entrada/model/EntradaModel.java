package slz.blog.entrada.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import slz.blog.categoria.entity.Categoria;
import slz.blog.etiqueta.entity.Etiqueta;
import slz.blog.global.utils.BlogConstants;

@Component
public class EntradaModel {

	private long idEntrada;
	
	private String autor;
	@NotEmpty(message= "El titulo de la entrada " + BlogConstants.ERROR_CAMPO_VACIO)
	private String tituloEntrada;
	private String fechaPublicacion;
	@NotEmpty(message= "El contenido de la entrada " + BlogConstants.ERROR_CAMPO_VACIO)
	private String contenidoEntrada;
	
	private List<Categoria> listadoCategoria;
	private List<Etiqueta> listadoEtiqueta;
	
	
	public long getIdEntrada() {
		return idEntrada;
	}
	
	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getTituloEntrada() {
		return tituloEntrada;
	}
	
	public void setTituloEntrada(String tituloEntrada) {
		this.tituloEntrada = tituloEntrada;
	}
	
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	
	public String getContenidoEntrada() {
		return contenidoEntrada;
	}
	
	public void setContenidoEntrada(String contenidoEntrada) {
		this.contenidoEntrada = contenidoEntrada;
	}

	public List<Categoria> getListadoCategoria() {
		return listadoCategoria;
	}

	public void setListadoCategoria(List<Categoria> listadoCategoria) {
		this.listadoCategoria = listadoCategoria;
	}

	public List<Etiqueta> getListadoEtiqueta() {
		return listadoEtiqueta;
	}

	public void setListadoEtiqueta(List<Etiqueta> listadoEtiqueta) {
		this.listadoEtiqueta = listadoEtiqueta;
	}

	
}
