package slz.blog.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import slz.blog.global.mapper.OrikaMapper;
import slz.blog.usuario.entity.Usuario;
import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private OrikaMapper orikaMapper;

	// Método para crear un usuario
	@Override
	@Transactional
	public boolean crearUsuario(UsuarioModel usuarioModel) {
		boolean altaCorrecta = false;
		Usuario usuario = null;

		try {		
			usuario = orikaMapper.map(usuarioModel, Usuario.class);
			usuario = usuarioRepository.save(usuario);
			altaCorrecta = true;
		} catch (Exception e) {
			throw e;
		}

		return altaCorrecta;
	}

	// Método para obtener un usuario
	@Override
	public UsuarioModel getUsuario(long idUsuario) {
		UsuarioModel usuarioModel = null;
		boolean existeUsuario = false;

		try {
			existeUsuario = existeUsuario(idUsuario);
			if(existeUsuario) {
				Usuario usuario = usuarioRepository.findOne(idUsuario);
				usuarioModel = orikaMapper.map(usuario, UsuarioModel.class);
			}
		} catch (Exception e) {
			throw e;
		}

		return usuarioModel;
	}

	// Método para listar todos los usuarios registrados del blog
	@Override
	public List<UsuarioModel> listUsuarios(UsuarioModel usuarioModel) {
		List<UsuarioModel> listadoUsuarioModel = new ArrayList<UsuarioModel>();

		try {
			List<Usuario> listadoUsuario = usuarioRepository.findAll();
			listadoUsuarioModel = orikaMapper.mapAsList(listadoUsuario, UsuarioModel.class);
		} catch (Exception e) {
			throw e;
		}

		return listadoUsuarioModel;
	}

	// Método para comprobar si ese usuario existe
	@Override
	public boolean existeUsuario(long idUsuario) {
		boolean existeUsuario = false;

		try {
			existeUsuario = usuarioRepository.exists(idUsuario);
		} catch (Exception e) {
			throw e;
		}

		return existeUsuario;
	}

	// Método para editar la información de un usuario nombre-password
	@Override
	public boolean editarUsuario(UsuarioModel usuarioModel) {
		boolean editado = false;
		
		try {
			Usuario usuario = usuarioRepository.findOne(usuarioModel.getIdUsuario());
			if(usuario != null) {
				Optional<String> optionalNombre = Optional.ofNullable(usuarioModel.getNombre());
				Optional<String> optionalPassword = Optional.ofNullable(usuarioModel.getPassword());
				optionalNombre.ifPresent(nombreEditado -> usuario.setNombre(nombreEditado));
				optionalPassword.ifPresent(passwordEditado -> usuario.setPassword(passwordEditado));
				usuarioRepository.save(usuario);
				editado = true;
			}
		} catch (Exception e) {
			throw e;
		}

		return editado;
	}

	// Método para dar baja de un usuario
	@Override
	public boolean bajaUsuario(long idUsuario) {
		boolean bajaCorrecta = false;
		boolean existeUsuario = false;

		try {
			existeUsuario = existeUsuario(idUsuario);
			if(existeUsuario) {
				usuarioRepository.delete(idUsuario);
				bajaCorrecta = true;
			}
		}catch (Exception e) {
			throw e;
		}

		return bajaCorrecta;
	}

}
