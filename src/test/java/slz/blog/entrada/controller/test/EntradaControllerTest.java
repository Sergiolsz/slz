package slz.blog.entrada.controller.test;

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

import slz.blog.entrada.controller.EntradaController;
import slz.blog.entrada.entity.Entrada;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.entrada.repository.EntradaRepository;
import slz.blog.entrada.service.EntradaService;
import slz.blog.global.model.RespuestaBlog;
import slz.blog.usuario.model.UsuarioModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={EntradaController.class})
public class EntradaControllerTest {

	@Autowired
	private EntradaController entradaController;

	@MockBean
	private EntradaService entradaService;

	@MockBean
	private EntradaRepository entradaRepository;

	@MockBean
	private Entrada entrada;

	@MockBean
	private EntradaModel entradaModel;

	@MockBean
	private List<EntradaModel> listadoEntradaModel;

	@MockBean
	private UsuarioModel usuarioModel;

	@MockBean
	private BindingResult result;

	@Before
	public void setUp() {

	}


	@Test
	public void testCrearEntrada() {
		given(entradaRepository.save(entrada)).willReturn(entrada);
		given(entradaService.crearEntrada(usuarioModel, entradaModel)).willReturn(true);
		ResponseEntity<RespuestaBlog> response =  entradaController.crearEntrada(usuarioModel, entradaModel, result);
		assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}

	@Test
	public void testCrearEntradaFalse() {
		given(entradaRepository.save(entrada)).willReturn(entrada);
		given(entradaService.crearEntrada(usuarioModel, entradaModel)).willReturn(false);
		ResponseEntity<RespuestaBlog> response =  entradaController.crearEntrada(usuarioModel, entradaModel, result);
		assertThat(response.getStatusCode()).isEqualTo( HttpStatus.NOT_MODIFIED);
	}

	@Test(expected = Exception.class)
	public void testCrearEntradaException() {
		given(entradaRepository.save(entrada)).willThrow(new Exception());
		given(entradaService.crearEntrada(usuarioModel, entradaModel)).willReturn(null);
		ResponseEntity<RespuestaBlog> response =  entradaController.crearEntrada(usuarioModel, entradaModel, result);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Test
	public void testBorrarEntrada() {
		given(entradaService.borrarEntrada(Mockito.anyLong())).willReturn(true);
		ResponseEntity<RespuestaBlog> response =  entradaController.borrarEntrada(Mockito.anyLong());
		assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}

	@Test
	public void testBorrarEntradaFalse() {
		given(entradaService.borrarEntrada(Mockito.anyLong())).willReturn(false);
		ResponseEntity<RespuestaBlog> response =  entradaController.borrarEntrada(Mockito.anyLong());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}

	@Test(expected = Exception.class)
	public void testBorrarEntradaException() {
		given(entradaService.borrarEntrada(Mockito.anyLong())).willThrow(new Exception());
		ResponseEntity<RespuestaBlog> response =  entradaController.borrarEntrada(Mockito.anyLong());
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
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
		given(entradaService.listadoEntradas(Mockito.anyObject())).willThrow(new Exception());
		ResponseEntity<List<EntradaModel>> response = entradaController.listadoEntradas(usuarioModel);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
