package slz.blog.entrada.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

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

import slz.blog.entrada.controller.EntradaController;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.entrada.service.EntradaService;
import slz.blog.usuario.model.UsuarioModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={EntradaController.class})
public class EntradaControllerTest {

	@Autowired
	private EntradaController entradaController;
	
	@MockBean
	private EntradaService entradaService;
	
	@MockBean
	private EntradaModel entradaModel;
	
	@MockBean
	private List<EntradaModel> listadoEntradaModel;
	
	@MockBean
	private UsuarioModel usuarioModel;

	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public void testGetListadoEntradas() {
		 given(entradaService.listadoEntradas(Mockito.anyObject())).willReturn(listadoEntradaModel);
		 ResponseEntity<List<EntradaModel>> response =  entradaController.listadoEntradas(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testGetListadoEntradasUsuario() {
		 given(entradaService.listadoEntradas(Mockito.anyObject())).willReturn(listadoEntradaModel);
		 ResponseEntity<List<EntradaModel>> response =  entradaController.listadoEntradas(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testGetListadoEntradasNull() {
		 given(entradaService.listadoEntradas(Mockito.anyObject())).willReturn(null);
		 ResponseEntity<List<EntradaModel>> response =  entradaController.listadoEntradas(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListadoEntradasException() {
		 when(entradaService.listadoEntradas(Mockito.anyObject())).thenThrow(new Exception());
		 ResponseEntity<List<EntradaModel>> response = entradaController.listadoEntradas(usuarioModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
