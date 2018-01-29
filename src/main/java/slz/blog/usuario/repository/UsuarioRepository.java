package slz.blog.usuario.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import slz.blog.usuario.entity.Usuario;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {

	 public Usuario findById(long id);
	 
	 public Usuario findByNick(String nick);
	 
	 public Usuario findByPassword(String password);
}
