package slz.blog.login.service;

import org.springframework.stereotype.Service;

import slz.blog.usuario.model.UsuarioModel;

@Service
public interface LoginService {

	public boolean getLogin(UsuarioModel usuario);
}
