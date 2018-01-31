package slz.blog.etiqueta.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import slz.blog.entrada.entity.Entrada;

@Entity
@Table(name = "etiqueta")
public class Etiqueta {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long idEtiqueta;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombreEtiqueta;

	@JoinColumn(name = "idEntrada", nullable = false)
	@ManyToOne(cascade =  CascadeType.ALL)
	private Entrada entrada;
	
	public long getIdEtiqueta() {
		return idEtiqueta;
	}

	public void setIdEtiqueta(long idEtiqueta) {
		this.idEtiqueta = idEtiqueta;
	}

	public String getNombreEtiqueta() {
		return nombreEtiqueta;
	}

	public void setNombreEtiqueta(String nombreEtiqueta) {
		this.nombreEtiqueta = nombreEtiqueta;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	
	
	
}
