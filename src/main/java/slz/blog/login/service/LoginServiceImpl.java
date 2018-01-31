package slz.blog.login.service;

import org.springframework.beans.factory.annotation.Autowired;

import slz.blog.usuario.entity.Usuario;
import slz.blog.usuario.model.UsuarioModel;
import slz.blog.usuario.repository.UsuarioRepository;

public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	@Override
	public boolean getLogin(UsuarioModel usuarioModel) {
		boolean usuarioCorrecto = false;

		try {
			Usuario usuario = usuarioRepository.getOne(usuarioModel.getNick());
			boolean usuarioExiste = usuarioRepository.exists(usuario.getNick());
			if(usuarioExiste && usuarioModel.getPassword().equals(usuario.getPassword())) {
				usuarioCorrecto = true;
			} 
		} catch(Exception e) {
			throw e;
		}

		return usuarioCorrecto;
	}

}
