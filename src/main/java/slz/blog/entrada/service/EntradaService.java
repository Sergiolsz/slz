package slz.blog.entrada.service;

import java.util.List;

import org.springframework.stereotype.Service;

import slz.blog.categoria.model.CategoriaModel;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.usuario.model.UsuarioModel;

@Service
public interface EntradaService {

	public boolean crearEntrada(UsuarioModel usuarioModel, EntradaModel crearEntrada);
	
	public boolean borrarEntrada(long idEntrada);

	public List<EntradaModel> listadoEntradas(UsuarioModel usuarioModel);

	public boolean addCategoriaEntrada(List<CategoriaModel> categorias, long idEntrada);
	
	public boolean addEtiquetaEntrada(List<EtiquetaModel> etiquetas, long idEntrada);
	
}
