package slz.blog.categoria.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slz.blog.categoria.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Serializable> {

}
