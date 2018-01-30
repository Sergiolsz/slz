package slz.blog.categoria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.categoria.entity.Categoria;
import slz.blog.categoria.model.CategoriaModel;
import slz.blog.categoria.repository.CategoriaRepository;
import slz.blog.global.mapper.OrikaMapper;

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
		boolean existe = false;

		try {
			existe = existeCategoria(idCategoria);
			if(existe) {
				Categoria categoria = categoriaRepository.findOne(idCategoria);
				categoriaModel = orikaMapper.map(categoria, CategoriaModel.class);
			}
		} catch (Exception e) {
			throw e;
		}

		return categoriaModel;
	}

	@Override
	public List<CategoriaModel> listCategoria() {
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
	public boolean editarCategoria(CategoriaModel categoriaModel) {
		boolean editado = false;

		try {
			Categoria categoria = categoriaRepository.findOne(categoriaModel.getIdCategoria());
			if(categoria != null) {
				Categoria categoriaEditada = orikaMapper.map(categoriaModel, Categoria.class);
				categoriaEditada.setNombre(categoria.getNombre());
				categoriaEditada = categoriaRepository.save(categoriaEditada);
				editado = true;
			}
		} catch (Exception e) {
			throw e;
		}

		return editado;
	}

	@Override
	public boolean borrarCategoria(long idCategoria) {
		boolean borradoCorrecto = false;
		boolean existeCategoria = false;

		try {
			existeCategoria = existeCategoria(idCategoria);
			if(existeCategoria) {
				categoriaRepository.delete(idCategoria);
				borradoCorrecto = true;
			}
		}catch (Exception e) {
			throw e;
		}

		return borradoCorrecto;
	}

}
