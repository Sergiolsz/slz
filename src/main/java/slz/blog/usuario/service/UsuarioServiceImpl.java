package slz.blog.usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.repository.UsuarioRepository;

@Component
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public boolean crearUsuario(UsuarioModel usuarioModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsuarioModel getUsuario(long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioModel> listUsuarios(UsuarioModel usuarioModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeUsuario(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editarUsuario(UsuarioModel usuarioModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaUsuario(long idUsuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
