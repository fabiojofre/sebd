package com.jofre.sebd.dao;

import java.util.List;

import com.jofre.sebd.domain.Filial;

public interface FilialDao {

	void save(Filial filial);
	
	void update(Filial filial);
	
	void delete(Integer id);
	
	Filial findById(Integer id);
	
	List<Filial>findAll();
	
}
