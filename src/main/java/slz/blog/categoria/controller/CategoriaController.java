package slz.blog.categoria.controller;

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

import slz.blog.categoria.model.CategoriaModel;
import slz.blog.categoria.service.CategoriaService;
import slz.blog.global.model.RespuestaBlog;
import slz.blog.global.utils.BlogUtil;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	/**
	 * 
	 * Crear una categoria del blog
	 * 
	 * @param crearCategoria
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("/crearCategoria")
	public ResponseEntity<RespuestaBlog> crearCategoria(@Validated @RequestBody CategoriaModel crearCategoria, BindingResult errors) {
		ResponseEntity<RespuestaBlog> responseCrear = null;

		try {
			if(!errors.hasErrors()) {
				boolean categoriaCreada = categoriaService.crearCategoria(crearCategoria);
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
	 * Borrado de una categoria del blog
	 * 
	 * @param idCategoria
	 * @return ResponseEntity
	 */
	@PostMapping("/borrarCategoria")
	public ResponseEntity<RespuestaBlog> borrarUsuario(@RequestParam(name = "idUsuario", required = true) long idCategoria) {
		ResponseEntity<RespuestaBlog> responseBorrar = null;

		try {
			boolean borrarOk= categoriaService.borrarCategoria(idCategoria);
			if(borrarOk) {
				responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.OK); 
			} else {
				responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.NOT_MODIFIED); 
			}
		} catch (Exception e) {
			responseBorrar = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}

		return responseBorrar;
	}

	/**
	 * 
	 * Edición de una categoria
	 * 
	 * @param editarCategoria
	 * @return ResponseEntity
	 */
	@PostMapping("/editarCategoria")
	public ResponseEntity<RespuestaBlog> editarDatosCliente(@Validated @RequestBody CategoriaModel editarCategoria) {
		ResponseEntity<RespuestaBlog> responseEditar = null;
		try {
			boolean editarOk= categoriaService.editarCategoria(editarCategoria);
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
	 * Devuelve el listado de categorias disponibles del blog
	 * 
	 * @return ResponseEntity<List<CategoriaModel>>
	 */
	@PostMapping("/listadoCategorias")
	public ResponseEntity<List<CategoriaModel>> listadoCategorias() {
		ResponseEntity<List<CategoriaModel>> responseListadoCategoria = null;
		List<CategoriaModel> listadoCategoria = new ArrayList<CategoriaModel>();
		
		try {
			listadoCategoria = categoriaService.listadoCategoria();	
			if (listadoCategoria != null) {
				responseListadoCategoria = new ResponseEntity<List<CategoriaModel>>(listadoCategoria,  HttpStatus.OK);
			} else {
				responseListadoCategoria = new ResponseEntity<List<CategoriaModel>>(listadoCategoria,  HttpStatus.NO_CONTENT);
			}
		} catch (Exception exception) {
			responseListadoCategoria = new ResponseEntity<List<CategoriaModel>>(listadoCategoria,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseListadoCategoria;
	}
}
