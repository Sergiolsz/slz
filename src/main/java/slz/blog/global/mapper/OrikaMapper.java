package slz.blog.global.mapper;

import java.util.Set;

import org.springframework.stereotype.Component;

import antlr.collections.List;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class OrikaMapper extends ConfigurableMapper {

	protected void configure(MapperFactory factory) {
		ConverterFactory converterFactory = factory.getConverterFactory();
		converterFactory.registerConverter("dateConverter", new OrikaDateConverter("dd/MM/yyyy"));
		factory.classMap(Set.class, List.class);

	}

}
