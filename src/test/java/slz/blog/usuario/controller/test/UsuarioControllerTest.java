package slz.blog.usuario.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;

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
import org.springframework.validation.BindingResult;

import slz.blog.global.model.RespuestaBlog;
import slz.blog.usuario.controller.UsuarioController;
import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={UsuarioController.class})
public class UsuarioControllerTest {

	@Autowired
	private UsuarioController usuarioController;
	
	@MockBean
	private UsuarioService usuarioService;
	
	@MockBean
	private UsuarioModel usuarioModel;
	
	@MockBean
	private List<UsuarioModel> listadoUsuarioModel;
	
	@MockBean
	private BindingResult result;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testCrearUsuario() {
		 given(usuarioService.crearUsuario(usuarioModel)).willReturn(true);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.crearUsuario(usuarioModel, result);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testCrearUsuarioNull() {
		 given(usuarioService.crearUsuario(usuarioModel)).willReturn(false);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.crearUsuario(usuarioModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test(expected = Exception.class)
	public void testCrearUsuarioException() {
		 given(usuarioService.crearUsuario(usuarioModel)).willThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = usuarioController.crearUsuario(usuarioModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testBorrarUsuario() {
		 given(usuarioService.bajaUsuario(Mockito.anyLong())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.borrarUsuario(1);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testBorrarUsuarioNull() {
		 given(usuarioService.bajaUsuario(Mockito.anyLong())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.borrarUsuario(1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testBorrarUsuarioException() {
		 given(usuarioService.bajaUsuario(Mockito.anyLong())).willThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = usuarioController.borrarUsuario(1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testEditarUsuario() {
		 given(usuarioService.editarUsuario(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.editarDatosUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testEditarUsuarioNull() {
		 given(usuarioService.editarUsuario(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response =  usuarioController.editarDatosUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testEditarUsuarioException() {
		 given(usuarioService.editarUsuario(Mockito.anyObject())).willThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = usuarioController.editarDatosUsuario(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testGetListadoUsuarios() {
		 given(usuarioService.listadoUsuarios()).willReturn(listadoUsuarioModel);
		 ResponseEntity<List<UsuarioModel>> response =  usuarioController.listadoUsuarios();
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testGetListadoUsuariosNull() {
		 given(usuarioService.listadoUsuarios()).willReturn(null);
		 ResponseEntity<List<UsuarioModel>> response =  usuarioController.listadoUsuarios();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListadoUsuariosException() {
		 given(usuarioService.listadoUsuarios()).willThrow(new Exception());
		 ResponseEntity<List<UsuarioModel>> response = usuarioController.listadoUsuarios();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
