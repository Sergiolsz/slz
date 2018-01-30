package slz.blog.etiqueta.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import slz.blog.global.utils.BlogConstants;

@Component
public class EtiquetaModel {

	private long idEtiqueta;
	@NotEmpty(message= "El nombre de la etiqueta " + BlogConstants.ERROR_CAMPO_VACIO)
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
