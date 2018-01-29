package slz.blog.entrada.entity;

import slz.blog.categoria.entity.Categoria;
import slz.blog.etiqueta.entity.Etiqueta;

public class Entrada {

	private int idEntrada;
	private int idUsuario;
	
	private String autor;
	
	private String tituloEntrada;
	
	private String fechaPublicacion;
	
	private String contenidoEntrada;
	
	private Categoria categoria;
	
	private Etiqueta etiqueta;

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
		this.idEntrada = idEntrada;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}
	
}
