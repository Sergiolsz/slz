package slz.blog.entrada.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import slz.blog.entrada.model.EntradaModel;
import slz.blog.entrada.service.EntradaService;
import slz.blog.global.model.RespuestaBlog;
import slz.blog.global.utils.BlogUtil;
import slz.blog.usuario.model.UsuarioModel;


@Controller
public class EntradaController {

	@Autowired
	private EntradaService entradaService;

	/**
	 * 
	 * Crear una entrada del blog
	 * 
	 * @param crearCategoria
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("/crearEntrada")
	public ResponseEntity<RespuestaBlog> crearEntrada(@Validated @RequestBody UsuarioModel usuarioModel, EntradaModel entradaModel, BindingResult errors) {
		ResponseEntity<RespuestaBlog> responseCrear = null;

		try {
			if(!errors.hasErrors()) {
				boolean categoriaCreada = entradaService.crearEntrada(usuarioModel, entradaModel);
				if(categoriaCreada) {
					responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.OK);
				} else {
					responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
				}
			} else {
				responseCrear  = BlogUtil.generarRespuestaErroresValidacion(errors);
			}
		} catch (Exception e) {
			responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return responseCrear;
	}

	/**
	 * 
	 * Borrado de una entrada
	 * 
	 * @param idEntrada
	 * @return ResponseEntity
	 */
	@PostMapping("/borrarEntrada")
	public ResponseEntity<RespuestaBlog> borrarEntrada(@RequestBody long idEntrada) {
		ResponseEntity<RespuestaBlog> responseBorrar = null;

		try {
			boolean entradaBorrada = entradaService.borrarEntrada(idEntrada);
			if(entradaBorrada) {
				responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.OK);
			} else {
				responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			}
		} catch (Exception e) {
			responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return responseBorrar;
	}

	/**
	 * 
	 * Listar las entradas que hay. Si se pasa un usuario listar las entradas de este usuario.
	 * 
	 * @param usuarioModel
	 * @return ResponseEntity<List<EntradaModel>>
	 */
	@PostMapping("/listadoEntradas")
	public ResponseEntity<List<EntradaModel>> listadoEntradas(@RequestBody(required = false) UsuarioModel usuarioModel) {
		ResponseEntity<List<EntradaModel>> responseListadoEtiquetas = null;
		List<EntradaModel> listadoEtiquetas = new ArrayList<EntradaModel>();
		try {
			listadoEtiquetas = entradaService.listadoEntradas(usuarioModel);
			if (listadoEtiquetas != null) {
				responseListadoEtiquetas = new ResponseEntity<List<EntradaModel>>(listadoEtiquetas,  HttpStatus.OK);
			} else {
				responseListadoEtiquetas = new ResponseEntity<List<EntradaModel>>(listadoEtiquetas,  HttpStatus.NO_CONTENT);
			}
		} catch (Exception exception) {
			responseListadoEtiquetas = new ResponseEntity<List<EntradaModel>>(listadoEtiquetas,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseListadoEtiquetas;
	}

}
