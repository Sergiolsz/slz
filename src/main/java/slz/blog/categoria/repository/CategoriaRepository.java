package slz.blog.categoria.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import slz.blog.categoria.entity.Categoria;

@Transactional
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable> {

}
