package slz.blog.categoria.controller.test;

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

import slz.blog.categoria.controller.CategoriaController;
import slz.blog.categoria.model.CategoriaModel;
import slz.blog.categoria.service.CategoriaService;
import slz.blog.entrada.service.EntradaService;
import slz.blog.global.model.RespuestaBlog;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={CategoriaController.class})
public class CategoriaControllerTest {

	@Autowired
	private CategoriaController categoriaController;
	
	@MockBean
    private CategoriaService categoriaService;
	
	@MockBean
    private EntradaService entradaService;
	
	@MockBean
	private List<CategoriaModel> listadoCategorias;
	
	@MockBean
	private CategoriaModel categoriaModel;

	@MockBean
	private BindingResult result;
 

	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testCrearCategoria() {
		 given(categoriaService.crearCategoria(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = categoriaController.crearCategoria(categoriaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testCrearCategoriaFalse() {
		 given(categoriaService.crearCategoria(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = categoriaController.crearCategoria(categoriaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
	
	@Test(expected = Exception.class)
	public void testCrearCategoriaException() {
		 when(categoriaService.crearCategoria(Mockito.anyObject())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = categoriaController.crearCategoria(categoriaModel, result);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testBorrarCategoria() {
		 given(categoriaService.borrarCategoria(Mockito.anyLong())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = categoriaController.borrarCategoria(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testBorrarCategoriaFalse() {
		 given(categoriaService.borrarCategoria(Mockito.anyLong())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = categoriaController.borrarCategoria(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testBorrarCategoriaException() {
		 when(categoriaService.borrarCategoria(Mockito.anyLong())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = categoriaController.borrarCategoria(Mockito.anyLong());
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testEditarCategoria() {
		 given(categoriaService.editarCategoria(Mockito.anyObject())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = categoriaController.editarCategoria(categoriaModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testEditarCategoriaFalse() {
		 given(categoriaService.editarCategoria(Mockito.anyObject())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = categoriaController.editarCategoria(categoriaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testEditarCategoriaException() {
		 when(categoriaService.editarCategoria(Mockito.anyObject())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = categoriaController.editarCategoria(categoriaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testGetListadoCategorias() {
		 given(categoriaService.listadoCategoria()).willReturn(listadoCategorias);
		 ResponseEntity<List<CategoriaModel>> response = categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testGetListadoCategoriasNull() {
		 given(categoriaService.listadoCategoria()).willReturn(null);
		 ResponseEntity<List<CategoriaModel>> response = categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListadoCategoriasException() {
		 when(categoriaService.listadoCategoria()).thenThrow(new Exception());
		 ResponseEntity<List<CategoriaModel>> response = categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void testAddCategoria() {
		 given(entradaService.addCategoriaEntrada(Mockito.anyObject(), Mockito.anyLong())).willReturn(true);
		 ResponseEntity<RespuestaBlog> response = categoriaController.addCategoria(listadoCategorias, 1);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testAddCategoriaNull() {
		 given(entradaService.addCategoriaEntrada(Mockito.anyObject(), Mockito.anyLong())).willReturn(false);
		 ResponseEntity<RespuestaBlog> response = categoriaController.addCategoria(listadoCategorias, 1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_MODIFIED);
	}
	
	@Test(expected = Exception.class)
	public void testAddCategoriaException() {
		 when(entradaService.addCategoriaEntrada(Mockito.anyObject(), Mockito.anyLong())).thenThrow(new Exception());
		 ResponseEntity<RespuestaBlog> response = categoriaController.addCategoria(listadoCategorias, 1);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
