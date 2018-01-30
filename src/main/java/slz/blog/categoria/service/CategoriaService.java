package slz.blog.categoria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import slz.blog.categoria.model.CategoriaModel;

@Service
public interface CategoriaService {

	public boolean crearCategoria(CategoriaModel categoriaModel);
	
	public abstract CategoriaModel getCategoria(long idCategoria);
	
	public List<CategoriaModel> listadoCategoria();
	
	public abstract boolean existeCategoria(long id);
	
	boolean editarCategoria(CategoriaModel usuarioModel);

	public boolean borrarCategoria(long idCategoria);
}
