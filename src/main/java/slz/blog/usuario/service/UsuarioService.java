package slz.blog.usuario.service;

import org.springframework.stereotype.Service;

import slz.blog.usuario.entity.Usuario;

@Service
public interface UsuarioService {

	Usuario crearUsuario();
	Usuario borrarUsuario();
	Usuario actualizarUsuario();
}
