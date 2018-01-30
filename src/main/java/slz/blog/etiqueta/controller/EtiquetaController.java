package slz.blog.etiqueta.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.etiqueta.service.EtiquetaService;
import slz.blog.global.model.RespuestaBlog;
import slz.blog.global.utils.BlogUtil;

@Controller
public class EtiquetaController {

	@Autowired
	private EtiquetaService etiquetaService;

	/**
	 * 
	 * Crear una etiqueta
	 * 
	 * @param crearEtiqueta
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("/crearEtiqueta")
	public ResponseEntity<RespuestaBlog> crearEtiqueta(@Validated @RequestBody EtiquetaModel crearEtiqueta, BindingResult errors) {
		ResponseEntity<RespuestaBlog> responseCrear = null;
		try {
			if(!errors.hasErrors()) {
				boolean usuarioCreado = etiquetaService.crearEtiqueta(crearEtiqueta);
				if(usuarioCreado) {
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
	 * Borrado de una etiqueta
	 * 
	 * @param idEtiqueta
	 * @return ResponseEntity
	 */
	@PostMapping("/borrarEtiqueta")
	public ResponseEntity<RespuestaBlog> borrarEtiqueta(@RequestParam(name = "idEtiqueta", required = true) long idEtiqueta) {
		ResponseEntity<RespuestaBlog> responseBorrar = null;
		try {
			boolean borrarOk= etiquetaService.borrarEtiqueta(idEtiqueta);
			responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.OK); 
			if(!borrarOk) {
				responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.NOT_MODIFIED); 
			}
		} catch (Exception e) {
			responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return responseBorrar;
	}

	/**
	 * 
	 * Edición de los datos de una etiqueta
	 * 
	 * @param usuarioModel
	 * @return ResponseEntity
	 */
	@PostMapping("/editarEtiqueta")
	public ResponseEntity<RespuestaBlog> editarEtiqueta(@Validated @RequestBody EtiquetaModel etiquetaEditada) {
		ResponseEntity<RespuestaBlog> responseEditar = null;
		try {
			boolean editarOk= etiquetaService.editarEtiqueta(etiquetaEditada);
			responseEditar = new ResponseEntity<RespuestaBlog>(HttpStatus.OK); 
			if(!editarOk) {
				responseEditar = new ResponseEntity<RespuestaBlog>(HttpStatus.NOT_MODIFIED); 
			}
		} catch (Exception e) {
			responseEditar = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return responseEditar;
	}

	/**
	 * 
	 * Devuelve el listado de las etiquetas creadas en el blog
	 * 
	 * @param usuarioModel
	 * @return ResponseEntity<List<EtiquetaModel>>
	 */
	@PostMapping("/listadoEtiquetas")
	public ResponseEntity<List<EtiquetaModel>> listadoEtiquetas(@RequestBody(required = false) EtiquetaModel etiquetaModel) {
		ResponseEntity<List<EtiquetaModel>> responseListadoEtiquetas = null;
		List<EtiquetaModel> listadoEtiquetas = new ArrayList<EtiquetaModel>();
		try {
			listadoEtiquetas = etiquetaService.listadoEtiqueta();
			if (listadoEtiquetas != null) {
				responseListadoEtiquetas = new ResponseEntity<List<EtiquetaModel>>(listadoEtiquetas,  HttpStatus.OK);
			} else {
				responseListadoEtiquetas = new ResponseEntity<List<EtiquetaModel>>(listadoEtiquetas,  HttpStatus.NO_CONTENT);
			}
		} catch (Exception exception) {
			responseListadoEtiquetas = new ResponseEntity<List<EtiquetaModel>>(listadoEtiquetas,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseListadoEtiquetas;
	}
}