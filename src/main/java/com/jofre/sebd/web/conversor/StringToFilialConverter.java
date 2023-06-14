package com.jofre.sebd.web.conversor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jofre.sebd.domain.Filial;
import com.jofre.sebd.service.FilialService;

@Component
public class StringToFilialConverter implements Converter<String, Filial> {

	@Autowired
	 private  FilialService filialService;
	
	
	@Override
	public Filial convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return filialService.buscarPorId(id);
	}

}
