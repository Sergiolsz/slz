package slz.blog.login.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import slz.blog.global.model.RespuestaBlog;
import slz.blog.login.service.LoginService;
import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={LoginController.class})
public class LoginControllerTest {

	@Autowired
	private LoginController loginController;
	
	@MockBean
	private LoginService loginService;
	
	@MockBean
	private UsuarioService usuarioService;
	
	@MockBean
	private UsuarioModel usuarioModel;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetLogin() {
		 given(loginService.getLogin(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response =  loginController.loginUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void testGetLoginFalse() {
		 given(loginService.getLogin(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response =  loginController.loginUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	}
	
	
	@Test(expected = Exception.class)
	public void testGetLoginCatch() {
		 given(usuarioService.listadoUsuarios()).willThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response =  loginController.loginUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
