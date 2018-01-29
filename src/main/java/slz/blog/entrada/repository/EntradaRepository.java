package slz.blog.entrada.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import slz.blog.entrada.entity.Entrada;

@Transactional
public interface EntradaRepository extends JpaRepository<Entrada, Serializable> {

}
