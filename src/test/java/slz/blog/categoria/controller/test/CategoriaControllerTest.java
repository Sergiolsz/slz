package slz.blog.categoria.controller.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import slz.blog.categoria.controller.CategoriaController;
import slz.blog.categoria.model.CategoriaModel;
import slz.blog.categoria.service.CategoriaService;


@RunWith(SpringRunner.class)
@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

	@Autowired
	private CategoriaController categoriaController;
	
	@MockBean
    private CategoriaService categoriaService;
	
	@MockBean
	private List<CategoriaModel> listadoCategorias;
	
	@MockBean
	private CategoriaModel categoria;

	@MockBean
	private BindingResult result;
 

	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public void testGetListadoCategorias() {
		 given(categoriaService.listadoCategoria()).willReturn(listadoCategorias);
		 ResponseEntity<List<CategoriaModel>> response =  categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	@Test
	public void testGetListacoCategoriasNull() {
		 given(categoriaService.listadoCategoria()).willReturn(null);
		 ResponseEntity<List<CategoriaModel>> response =  categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListacoCategoriasException() {
		 when(categoriaService.listadoCategoria()).thenThrow(new Exception());
		 ResponseEntity<List<CategoriaModel>> response =  categoriaController.listadoCategorias();
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
