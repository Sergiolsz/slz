package slz.blog.etiqueta.controller.test;

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

import slz.blog.entrada.service.EntradaService;
import slz.blog.etiqueta.controller.EtiquetaController;
import slz.blog.etiqueta.model.EtiquetaModel;
import slz.blog.etiqueta.service.EtiquetaService;
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
	
	
	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public void testGetListadoEtiquetas() {
		 given(etiquetaService.listadoEtiqueta()).willReturn(listadoEtiquetaModel);
		 ResponseEntity<List<EtiquetaModel>> response =  etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo( HttpStatus.OK);
	}
	
	
	@Test
	public void testGetListadoEtiquetasNull() {
		 given(etiquetaService.listadoEtiqueta()).willReturn(null);
		 ResponseEntity<List<EtiquetaModel>> response =  etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}
	
	@Test(expected = Exception.class)
	public void testGetListadoEtiquetasException() {
		 when(etiquetaService.listadoEtiqueta()).thenThrow(new Exception());
		 ResponseEntity<List<EtiquetaModel>> response = etiquetaController.listadoEtiquetas(etiquetaModel);
		 assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
