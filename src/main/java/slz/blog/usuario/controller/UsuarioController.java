package slz.blog.usuario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import slz.blog.usuario.entity.Usuario;
import slz.blog.usuario.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String password) {
		Usuario user = null;
		try {
			user = new Usuario(name, password);
			usuarioRepository.save(user);
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created" ;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String password) {
		
		Optional<String> optional = Optional.ofNullable(password);
		Usuario usuario = null;
		String pass = null;
		try {
			usuario = usuarioRepository.findByPassword(optional.toString());
			optional.ifPresent(idUsuario -> usuarioRepository.findByPassword(idUsuario));
		}
		catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
}
