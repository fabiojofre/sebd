package com.jofre.sebd.web.conversor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.jofre.sebd.domain.Area;
import com.jofre.sebd.service.AreaService;

@Component
public class StringToAreaConverter implements Converter<String, Area> {

	@Autowired
	 private  AreaService areaService;
	
	
	@Override
	public Area convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return areaService.buscarPorId(id);
	}

}
