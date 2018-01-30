package slz.blog.entrada.service;

import org.springframework.stereotype.Service;

import slz.blog.entrada.model.EntradaModel;
import slz.blog.usuario.model.UsuarioModel;

@Service
public interface EntradaService {

	public EntradaModel crearEntrada(UsuarioModel usuarioModel, EntradaModel crearEntrada);
	
	public boolean borrarEntrada(long idEntrada);
}
