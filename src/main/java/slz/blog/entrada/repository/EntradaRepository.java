package slz.blog.entrada.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slz.blog.entrada.entity.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Serializable> {

	List<Entrada> findAll(long idUsuario);

}
