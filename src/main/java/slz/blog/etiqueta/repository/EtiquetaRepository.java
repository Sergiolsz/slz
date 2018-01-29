package slz.blog.etiqueta.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import slz.blog.etiqueta.entity.Etiqueta;

@Transactional
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Serializable> {

}
