package slz.blog.usuario.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
	
	
	@Before
	public void setUp() {
		
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
		 when(usuarioService.listadoUsuarios()).thenThrow(new Exception());
		 ResponseEntity<List<UsuarioModel>> response = usuarioController.listadoUsuarios();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
