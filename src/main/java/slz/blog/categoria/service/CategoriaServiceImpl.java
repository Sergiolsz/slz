package slz.blog.categoria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.categoria.entity.Categoria;
import slz.blog.categoria.model.CategoriaModel;
import slz.blog.categoria.repository.CategoriaRepository;
import slz.blog.global.mapper.OrikaMapper;
import slz.blog.usuario.entity.Usuario;
import slz.blog.usuario.model.UsuarioModel;

@Component
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private OrikaMapper orikaMapper;
	
	@Override
	public boolean crearCategoria(CategoriaModel categoriaModel) {
		Categoria categoria = null;
		boolean creadaCategoria = false;
		
		try {
			categoria = orikaMapper.map(categoriaModel, Categoria.class);
			categoria = categoriaRepository.save(categoria);
			creadaCategoria = true;
		} catch (Exception e) {
			throw e;
		}
		
		return creadaCategoria;
	}

	@Override
	public CategoriaModel getCategoria(long idCategoria) {
		CategoriaModel categoriaModel = null;
		boolean existeCategoria = false;

		try {
			existeCategoria = existeCategoria(idCategoria);
			if(existeCategoria) {
				Categoria categoria = categoriaRepository.findOne(idCategoria);
				categoriaModel = orikaMapper.map(categoria, CategoriaModel.class);
			}
		} catch (Exception e) {
			throw e;
		}

		return categoriaModel;
	}

	@Override
	public List<CategoriaModel> listCategoria(CategoriaModel categoriaModel) {
		List<CategoriaModel> listadoCategoriaModel = new ArrayList<CategoriaModel>();

		try {
			List<Categoria> listadoCategoria = categoriaRepository.findAll();
			listadoCategoriaModel = orikaMapper.mapAsList(listadoCategoria, CategoriaModel.class);
		} catch (Exception e) {
			throw e;
		}

		return listadoCategoriaModel;
	}

	@Override
	public boolean existeCategoria(long idCategoria) {
		boolean existeCategoria = false;

		try {
			existeCategoria = categoriaRepository.exists(idCategoria);
		} catch (Exception e) {
			throw e;
		}

		return existeCategoria;
	}

	@Override
	public boolean editarCategoria(CategoriaModel usuarioModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrarCategoria(long idCategoria) {
		// TODO Auto-generated method stub
		return false;
	}

}
