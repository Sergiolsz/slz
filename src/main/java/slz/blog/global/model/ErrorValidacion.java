package slz.blog.global.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorValidacion {

	String campo;
	String mensajeError;
	
	
	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getMensajeError() {
		return mensajeError;
	}
	
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}

}
