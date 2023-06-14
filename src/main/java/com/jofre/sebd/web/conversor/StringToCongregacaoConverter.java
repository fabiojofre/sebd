package com.jofre.sebd.web.conversor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jofre.sebd.domain.Congregacao;
import com.jofre.sebd.service.CongregacaoService;

@Component
public class StringToCongregacaoConverter implements Converter<String, Congregacao> {

	@Autowired
	 private  CongregacaoService congregacaoService;
	
	
	@Override
	public Congregacao convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return congregacaoService.buscarPorId(id);
	}

}
