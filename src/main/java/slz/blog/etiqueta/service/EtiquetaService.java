package slz.blog.etiqueta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import slz.blog.etiqueta.model.EtiquetaModel;

@Service
public interface EtiquetaService {

	public boolean crearEtiqueta(EtiquetaModel etiquetaModel);
	
	public List<EtiquetaModel> listadoEtiqueta();
	
	public boolean editarEtiqueta(EtiquetaModel etiquetaModel);

	public boolean borrarEtiqueta(long idEtiqueta);
	
}
