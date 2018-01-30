package slz.blog.entrada.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import slz.blog.categoria.entity.Categoria;
import slz.blog.etiqueta.entity.Etiqueta;

@Entity
@Table(name = "entrada")
public class Entrada {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int idEntrada;
	
	@Column(name = "autor", nullable = false, length = 50)
	private String autor;

	@Column(name = "titulo", nullable = false, length = 50)
	private String tituloEntrada;
	
	@Generated(GenerationTime.INSERT)
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable=false)
	private String fechaPublicacion;
	
	@Column(name = "contenido", nullable = false, length = 500)
	private String contenidoEntrada;
	
	private Categoria categoria;
	private Etiqueta etiqueta;

	public int getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(int idEntrada) {
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
