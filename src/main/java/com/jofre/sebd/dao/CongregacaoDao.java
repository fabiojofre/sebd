package com.jofre.sebd.dao;

import java.util.List;

import com.jofre.sebd.domain.Congregacao;

public interface CongregacaoDao {
	
void save(Congregacao congregaqcao);
	
	void update(Congregacao congregaqcao);
	
	void delete(Integer id);
	
	Congregacao findById(Integer id);
	
	List<Congregacao>findAll();
	
}
