package slz.blog.global.mapper;

import org.springframework.stereotype.Component;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import slz.blog.entrada.entity.Entrada;
import slz.blog.entrada.model.EntradaModel;
import slz.blog.usuario.model.UsuarioModel;

@Component
public class OrikaMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("dateConverter", new OrikaDateConverter("dd/MM/yyyy"));
		factory.classMap(EntradaModel.class, UsuarioModel.class)
		.field("autor", "nombre")
		.byDefault()
		.register();
		factory.classMap(Entrada.class, EntradaModel.class)
		.fieldMap("fechaPublicacion", "fechaPublicacion").converter("dateConverter").add()
		.byDefault()
		.register();
	}

}
