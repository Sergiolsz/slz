package slz.blog.global.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import slz.blog.global.mapper.OrikaMapper;
import slz.blog.global.model.ErrorValidacion;
import slz.blog.global.model.RespuestaBlog;



/**
 * 
 * Clase de utilidades para los servicios, validaciones.
 * 
 */
public class BlogUtil {
	private static Log log = LogFactory.getLog(BlogUtil.class);

	/**
	 * 
	 * Método que encripta una cadena String en Base64
	 * 
	 * @param cadena
	 * @return sB64
	 */
	public static String encriptarBase64 (final String cadena) {
		String sB64 = "";

		try {
			byte[] b64 = Base64.encodeBase64(cadena.getBytes());
			sB64 = new String(b64);
		} catch (Exception e) {
			log.info(e);
		}

		return sB64;
	}

	/**
	 * 
	 * Método que desencripta una cadena en Base64 a String
	 * 
	 * @param cadena
	 * @return sB64
	 */
	public static String desencriptarBase64(final String cadena) {
		String sB64 = "";

		try {
			byte[] b64 = Base64.decodeBase64(cadena.getBytes());
			sB64 = new String(b64);
		} catch (Exception e) {
			log.error(e);
		}

		return sB64;
	}

	/**
	 * 
	 * Método que verifica si una cadena es numérica
	 * 
	 * @param cadena
	 * @return boolean
	 */
	public static boolean esNumero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	// Metodo para comprobar que no es null un objeto
	public static boolean getValor(Object objeto) {
		boolean present = false;

		Optional<Object> opt = Optional.of(objeto);
		opt.ifPresent(opId -> getTrue(present));

		return present;
	}

	// Metodo para comprobar que no es null el parametro id
	public static boolean getId(boolean id) {
		Optional<Boolean> optId = Optional.of(id);
		optId.ifPresent(opId -> getTrue(id));

		return id;
	}

	public static final <T> boolean esListadoVacio(Set<T> listado) {
		return listado == null || listado.size() == 0 ? true : false;
	}

	private static boolean getTrue(boolean id) {
		id = true;
		return id;
	}

	public static final <T> boolean esListaVacia(Set<T> lista) {
		return StringUtils.isEmpty(lista) || lista.size() == 0 ? true : false;
	}

	public static final ResponseEntity<RespuestaBlog> generarRespuestaErroresValidacion(Errors errors) {
		OrikaMapper mapper = new OrikaMapper();
		List<ErrorValidacion>  erroresValidacion = mapper.mapAsList(errors.getAllErrors(), ErrorValidacion.class);
		RespuestaBlog respuesta = new RespuestaBlog(erroresValidacion);
		return new ResponseEntity<RespuestaBlog>(respuesta, HttpStatus.BAD_REQUEST);
	}

	public static Date StringToDate(String pattern, String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date date = null;
		System.out.println("source ::: " + dateStr);
		try {
			if (dateStr!=null){
				date = formatter.parse(dateStr);
				System.out.println(date);
				System.out.println(formatter.format(date));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}

	public static String DateToString(String pattern, Date date) {
		String dateStr = null;
		try {
			dateStr = new SimpleDateFormat(pattern).format(date);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return dateStr;
	}

}
