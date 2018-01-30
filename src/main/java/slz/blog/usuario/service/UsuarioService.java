package slz.blog.usuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import slz.blog.usuario.model.UsuarioModel;

@Service
public interface UsuarioService {

	public boolean crearUsuario(UsuarioModel usuarioModel);
	
	public abstract UsuarioModel getUsuario(long idUsuario);
	
	public List<UsuarioModel> listUsuarios(UsuarioModel usuarioModel);
	
	public abstract boolean existeUsuario(long id);

	boolean editarUsuario(UsuarioModel usuarioModel);

	public boolean bajaUsuario(long idUsuario);

}
