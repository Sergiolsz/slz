package slz.blog.etiqueta.controller.test;

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
import org.springframework.validation.BindingResult;

import slz.blog.entrada.service.EntradaService;
import slz.blog.etiqueta.controller.EtiquetaController;
import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.etiqueta.service.EtiquetaService;
import slz.blog.global.model.RespuestaBlog;
import slz.blog.usuario.model.UsuarioModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={EtiquetaController.class})
public class EtiquetaControllerTest {

	@Autowired
	private EtiquetaController etiquetaController;
	
	@MockBean
	private EtiquetaService etiquetaService;
	
	@MockBean
	private EntradaService entradaService;
	
	@MockBean
	private EtiquetaModel etiquetaModel;
	
	@MockBean
	private List<EtiquetaModel> listadoEtiquetaModel;
	
	@MockBean
	private UsuarioModel usuarioModel;
	
	@MockBean
	private BindingResult result;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testCrearEtiqueta() {
		 given(etiquetaService.crearEtiqueta(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.crearEtiqueta(etiquetaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testCrearEtiquetaFalse() {
		 given(etiquetaService.crearEtiqueta(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.crearEtiqueta(etiquetaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test(expected = Exception.class)
	public void testCrearEtiquetaException() {
		 when(etiquetaService.crearEtiqueta(Mockito.anyObject())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = etiquetaController.crearEtiqueta(etiquetaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testBorrarEtiqueta() {
		 given(etiquetaService.borrarEtiqueta(Mockito.anyLong())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.borrarEtiqueta(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testBorrarEtiquetaFalse() {
		 given(etiquetaService.borrarEtiqueta(Mockito.anyLong())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.borrarEtiqueta(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testBorrarEtiquetaException() {
		 when(etiquetaService.borrarEtiqueta(Mockito.anyLong())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = etiquetaController.borrarEtiqueta(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testEditarEtiqueta() {
		 given(etiquetaService.editarEtiqueta(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.editarEtiqueta(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testEditarEtiquetaFalse() {
		 given(etiquetaService.editarEtiqueta(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.editarEtiqueta(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testEditarEtiquetaException() {
		 when(etiquetaService.editarEtiqueta(Mockito.anyObject())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = etiquetaController.editarEtiqueta(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testGetListadoEtiquetas() {
		 given(etiquetaService.listadoEtiqueta()).willReturn(listadoEtiquetaModel);
		 ResponseEntity<List<EtiquetaModel>> response = etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	
	@Test
	public void testGetListadoEtiquetasNull() {
		 given(etiquetaService.listadoEtiqueta()).willReturn(null);
		 ResponseEntity<List<EtiquetaModel>> response = etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListadoEtiquetasException() {
		 when(etiquetaService.listadoEtiqueta()).thenThrow(new Exception());
		 ResponseEntity<List<EtiquetaModel>> response = etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testAddEtiqueta() {
		 given(entradaService.addEtiquetaEntrada(Mockito.anyObject(), Mockito.anyLong())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response =  etiquetaController.addEtiqueta(listadoEtiquetaModel, 1);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testAddEtiquetaNull() {
		 given(entradaService.addEtiquetaEntrada(Mockito.anyObject(), Mockito.anyLong())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = etiquetaController.addEtiqueta(listadoEtiquetaModel, 1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testAddEtiquetaException() {
		 when(entradaService.addEtiquetaEntrada(Mockito.anyObject(), Mockito.anyLong())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = etiquetaController.addEtiqueta(listadoEtiquetaModel, 1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
