package com.jofre.sebd.service;

import java.util.List;

import com.jofre.sebd.domain.Area;

public interface AreaService {

	void salvar(Area area);
	
	void editar(Area area);
	
	void excluir(Integer id);
	
	Area buscarPorId(Integer id);
	
	List<Area>buscarTodos();

	boolean areaTemCongregacao(Integer id);
}
