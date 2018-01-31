package slz.blog.etiqueta.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.etiqueta.entity.Etiqueta;
import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.etiqueta.repository.EtiquetaRepository;
import slz.blog.global.mapper.OrikaMapper;

@Component
public class EtiquetaServiceImpl implements EtiquetaService {

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	@Autowired
	private OrikaMapper orikaMapper;

	// Método para crear etiquetas
	@Override
	public boolean crearEtiqueta(EtiquetaModel etiquetaModel) {
		boolean etiquetaCreada = false;

		try {
			Etiqueta etiqueta = orikaMapper.map(etiquetaModel, Etiqueta.class);
			etiqueta = etiquetaRepository.save(etiqueta);
			etiquetaCreada = true;
		} catch (Exception e) {
			throw e;
		}

		return etiquetaCreada;
	}

	// Método para listar todas las etiquetas del blog
	@Override
	public List<EtiquetaModel> listadoEtiqueta() {
		List<EtiquetaModel> listadoEtiquetaModel = new ArrayList<EtiquetaModel>();

		try {
			List<Etiqueta> listadoEtiqueta = etiquetaRepository.findAll();
			listadoEtiquetaModel = orikaMapper.mapAsList(listadoEtiqueta, EtiquetaModel.class);
		} catch (Exception e) {
			throw e;
		}

		return listadoEtiquetaModel;
	}

	// Método para editar una etiqueta
	@Override
	public boolean editarEtiqueta(EtiquetaModel etiquetaModel) {
		boolean editado = false;

		try {
			Etiqueta etiqueta = etiquetaRepository.findOne(etiquetaModel.getIdEtiqueta());
			if(etiqueta != null) {
				Optional<String> optionalNombre = Optional.ofNullable(etiquetaModel.getNombreEtiqueta());
				optionalNombre.ifPresent(nombreEditado -> etiqueta.setNombreEtiqueta(nombreEditado));
				etiquetaRepository.save(etiqueta);
				editado = true;
			}
		} catch (Exception e) {
			throw e;
		}

		return editado;
	}

	// Método para borrar una etiqueta
	@Override
	public boolean borrarEtiqueta(long idEtiqueta) {
		boolean etiquetaBorrada = false;
		boolean existe = false;
		try {
			existe = existeEtiqueta(idEtiqueta); 
			if(existe) {
				Etiqueta etiqueta = etiquetaRepository.getOne(idEtiqueta);
				etiquetaRepository.delete(etiqueta);
				etiquetaBorrada = true;
			}
		} catch (Exception e) {
			throw e;
		}

		return etiquetaBorrada;
	}

	// Método para comprobación de que existe una etiqueta
	private boolean existeEtiqueta(long idEtiqueta) {
		boolean existeUsuario = false;

		try {
			existeUsuario = etiquetaRepository.exists(idEtiqueta);
		} catch (Exception e) {
			throw e;
		}

		return existeUsuario;
	}
	
}
