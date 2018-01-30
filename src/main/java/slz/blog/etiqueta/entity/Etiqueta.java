package slz.blog.etiqueta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etiqueta")
public class Etiqueta {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long idEtiqueta;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombreEtiqueta;

	
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
	
}
