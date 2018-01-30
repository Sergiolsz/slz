package slz.blog.global.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RespuestaBlog {
	private List<ErrorValidacion> mensajesValidacion;
	
	public RespuestaBlog(List<ErrorValidacion> mensajesValidacion) {
		this.mensajesValidacion = mensajesValidacion;
	}

	public List<ErrorValidacion> getMensajesValidacion() {
		return mensajesValidacion;
	}

	public void setMensajesValidacion(List<ErrorValidacion> mensajesValidacion) {
		this.mensajesValidacion = mensajesValidacion;
	}
}
