package slz.blog.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import slz.blog.global.model.RespuestaBlog;
import slz.blog.login.service.LoginService;
import slz.blog.usuario.model.UsuarioModel;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;


	/**
	 * 
	 * Login de un usuario registrado
	 * 
	 * @param altaUsuario
	 * @param errors
	 * @return ResponseEntity
	 */
	@PostMapping("/login")
	public ResponseEntity<RespuestaBlog> loginUsuario(@RequestBody UsuarioModel loginUsuario) {
		ResponseEntity<RespuestaBlog> responseCrear = null;
		try {
			boolean usuarioLogin = loginService.getLogin(loginUsuario);
			if(usuarioLogin) {
				responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.OK);
			} else {
				responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			responseCrear = new ResponseEntity<RespuestaBlog>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return responseCrear;
	}
}
