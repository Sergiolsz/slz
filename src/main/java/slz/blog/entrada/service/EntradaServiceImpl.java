package slz.blog.entrada.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.categoria.entity.Categoria;
import slz.blog.entrada.entity.Entrada;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.entrada.repository.EntradaRepository;
import slz.blog.etiqueta.entity.Etiqueta;
import slz.blog.global.mapper.OrikaMapper;
import slz.blog.usuario.model.UsuarioModel;

@Component
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private OrikaMapper orikaMapper;
	
	
	@Override
	public EntradaModel crearEntrada(UsuarioModel usuario, EntradaModel crearEntrada) {
		EntradaModel entradaModel = null;
		Entrada entrada = null;
		Optional<EntradaModel> optionalEntrada = Optional.ofNullable(crearEntrada);
		
		if(optionalEntrada.isPresent()) {	
			Optional<List<Categoria>> optionalListadoCategorias = Optional.ofNullable(crearEntrada.getListadoCategoria());
			Optional<List<Etiqueta>> optionalListadoEtiquetas = Optional.ofNullable(crearEntrada.getListadoEtiqueta());
			try {
				crearEntrada = orikaMapper.map(usuario.getNombre(), EntradaModel.class);
				optionalListadoCategorias.ifPresent(listadoCategorias -> addCategoriaEntrada(listadoCategorias));
				optionalListadoEtiquetas.ifPresent(listadoEtiqueta -> addEtiqueta(listadoEtiqueta));
				entrada = orikaMapper.map(crearEntrada, Entrada.class);
				entrada = entradaRepository.save(entrada);
				entradaModel = orikaMapper.map(entrada, EntradaModel.class);
			} catch (Exception e) {
				throw e;
			}
		}
		
		return entradaModel;
	}

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
	
	// Método para comprobar si la entrada a borrar existe
	private boolean existeEntrada(long idEntrada) {
		boolean existeEntrada = false;

		try {
			existeEntrada = entradaRepository.exists(idEntrada);
		} catch (Exception e) {
			throw e;
		}

		return existeEntrada;
	}
	
	
	private EntradaModel addCategoriaEntrada(List<Categoria> listadoCategorias) {
		return null;
		
	}

	private void addEtiqueta(List<Etiqueta> listadoEtiqueta) {
		
	}
}
