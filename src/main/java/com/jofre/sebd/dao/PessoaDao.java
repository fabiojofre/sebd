package com.jofre.sebd.dao;

import java.util.List;

import com.jofre.sebd.domain.Pessoa;

public interface PessoaDao {
	void save(Pessoa pessoa);
	
	void update(Pessoa pessoa);
	
	void delete(Integer id);
	
	Pessoa findById(Integer id);
	
	List<Pessoa>findAll();

}
