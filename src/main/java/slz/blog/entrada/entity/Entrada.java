package slz.blog.entrada.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Date fechaPublicacion;
	
	@Column(name = "contenido", nullable = false, length = 500)
	private String contenidoEntrada;
	
	@OneToMany(mappedBy="entrada")
	private Set<Categoria> categorias;
	
	@OneToMany(mappedBy="entrada")
	private Set<Etiqueta> etiquetas;

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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getContenidoEntrada() {
		return contenidoEntrada;
	}

	public void setContenidoEntrada(String contenidoEntrada) {
		this.contenidoEntrada = contenidoEntrada;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(Set<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}
}
