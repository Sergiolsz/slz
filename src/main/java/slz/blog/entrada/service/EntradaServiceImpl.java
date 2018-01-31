package slz.blog.entrada.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.categoria.entity.Categoria;
import slz.blog.categoria.model.CategoriaModel;
import slz.blog.entrada.entity.Entrada;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.entrada.repository.EntradaRepository;
import slz.blog.etiqueta.entity.Etiqueta;
import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.global.mapper.OrikaMapper;
import slz.blog.usuario.model.UsuarioModel;

@Component
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private OrikaMapper orikaMapper;


	// Método para crear una entrada en el blog
	@Override
	public boolean crearEntrada(UsuarioModel usuario, EntradaModel crearEntrada) {
		boolean creada = false;
		EntradaModel entradaCreada = null;
		Entrada entrada = null;
		Optional<EntradaModel> optionalEntrada = Optional.ofNullable(crearEntrada);

		if(optionalEntrada.isPresent()) {	
			try {
				entradaCreada = orikaMapper.map(crearEntrada, EntradaModel.class);
				entradaCreada = orikaMapper.map(usuario.getNick(), EntradaModel.class);
				entrada = orikaMapper.map(entradaCreada, Entrada.class);
				entrada = entradaRepository.save(entrada);
				entradaCreada = orikaMapper.map(entrada, EntradaModel.class);
				creada = true;
			} catch (Exception e) {
				throw e;
			}
		}

		return creada;
	}

	// Método para borrar una entrada del blog
	@Override
	public boolean borrarEntrada(long idEntrada) {
		boolean borradoEntrada = false;
		boolean existeEntrada = false;

		try {
			existeEntrada = existeEntrada(idEntrada);
			if(existeEntrada) {
				entradaRepository.delete(idEntrada);
				borradoEntrada = true;
			}
		}catch (Exception e) {
			throw e;
		}

		return borradoEntrada;
	}

	// Método para listar las entradas del blog y si se pasa un usuario, listar las entradas de ese usuario
	@Override
	public List<EntradaModel> listadoEntradas(UsuarioModel usuarioModel) {
		List<EntradaModel> listadoEntradasModel = new ArrayList<EntradaModel>();
		List<Entrada> listadoEntradas = new ArrayList<Entrada>();
		Optional<UsuarioModel> optionalUsuario = Optional.ofNullable(usuarioModel);
		
		try {
			if(optionalUsuario.isPresent()) {
				listadoEntradas = entradaRepository.findAll(usuarioModel.getIdUsuario());
			} else {
				listadoEntradas = entradaRepository.findAll();
			}
			listadoEntradasModel = orikaMapper.mapAsList(listadoEntradas, EntradaModel.class);
		} catch (Exception e) {
			throw e;
		}

		return listadoEntradasModel;
	}

	// Método para añadir una categoria al blog
	@Override
	public boolean addCategoriaEntrada(List<CategoriaModel> categorias, long idEntrada) {
		boolean addListadoCategorias = false;
		try {
			Set<Categoria> listadoCategorias = orikaMapper.mapAsSet(categorias, Categoria.class);
			Entrada entrada = entradaRepository.findOne(idEntrada);
			entrada.setCategorias(listadoCategorias);
			entradaRepository.save(entrada);
			addListadoCategorias = true;
		} catch (Exception e) {
			throw e;
		}
		return addListadoCategorias;
	}

	// Método para añadir una etiqueta a una entrada del blog
	@Override
	public boolean addEtiquetaEntrada(List<EtiquetaModel> etiquetas, long idEntrada) {
		boolean addListadoEtiquetas = false;
		try {
			Set<Etiqueta> listadoEtiquetas = orikaMapper.mapAsSet(etiquetas, Etiqueta.class);
			Entrada entrada = entradaRepository.findOne(idEntrada);
			entrada.setEtiquetas(listadoEtiquetas);
			entradaRepository.save(entrada);
			addListadoEtiquetas = true;
		} catch (Exception e) {
			throw e;
		}
		return addListadoEtiquetas;
	}
	
	// Método para comprobar si la entrada existe
	private boolean existeEntrada(long idEntrada) {
		boolean existeEntrada = false;

		try {
			existeEntrada = entradaRepository.exists(idEntrada);
		} catch (Exception e) {
			throw e;
		}

		return existeEntrada;
	}

}
