package slz.blog.usuario.controller;

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

import slz.blog.global.model.RespuestaBlog;
import slz.blog.global.utils.BlogUtil;
import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	/**
	 * 
	 * Alta de un usuario del blog
	 * 
	 * @param altaUsuario
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("/create")
	public ResponseEntity<RespuestaBlog> crearUsuario(@Validated @RequestBody UsuarioModel altaUsuario, BindingResult errors) {
		ResponseEntity<RespuestaBlog> responseCrear = null;
		try {
			if(!errors.hasErrors()) {
				boolean usuarioCreado = usuarioService.crearUsuario(altaUsuario);
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
	 * Borrado de un usuario del blog
	 * 
	 * @param idUsuario
	 * @return ResponseEntity
	 */
	@PostMapping("/delete")
	public ResponseEntity<RespuestaBlog> borrarUsuario(@RequestParam(name = "idUsuario", required = true) long idUsuario) {
		ResponseEntity<RespuestaBlog> responseBorrar = null;
		try {
			boolean borrarOk= usuarioService.bajaUsuario(idUsuario);
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
	 * Edición de los datos de un usuario del blog
	 * 
	 * @param usuarioModel
	 * @return ResponseEntity
	 */
	@PostMapping("/edit")
	public ResponseEntity<RespuestaBlog> editarDatosCliente(@Validated @RequestBody UsuarioModel usuarioModel) {
		ResponseEntity<RespuestaBlog> responseEditar = null;
		try {
			boolean editarOk= usuarioService.editarUsuario(usuarioModel);
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
	 * Devuelve el listado de usuarios registrados en el blog
	 * 
	 * @param usuarioModel
	 * @return ResponseEntity<List<UsuarioModel>>
	 */
	@PostMapping("/list")
	public ResponseEntity<List<UsuarioModel>> listUsuarios(@RequestBody(required = false) UsuarioModel usuarioModel) {
		ResponseEntity<List<UsuarioModel>> responseListUsuarios = null;
		List<UsuarioModel> listadoUsuarios = new ArrayList<UsuarioModel>();
		try {
			listadoUsuarios = usuarioService.listUsuarios(usuarioModel);
			if (listadoUsuarios != null) {
				responseListUsuarios = new ResponseEntity<List<UsuarioModel>>(listadoUsuarios,  HttpStatus.OK);
			} else {
				responseListUsuarios = new ResponseEntity<List<UsuarioModel>>(listadoUsuarios,  HttpStatus.NO_CONTENT);
			}
		} catch (Exception exception) {
			responseListUsuarios = new ResponseEntity<List<UsuarioModel>>(listadoUsuarios,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseListUsuarios;
	}
}
