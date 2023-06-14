package com.jofre.sebd.service;

import java.util.List;

import com.jofre.sebd.domain.Filial;

public interface FilialService {

	void salvar(Filial filial);
	
	void editar(Filial filial);
	
	void excluir(Integer id);
	
	Filial buscarPorId(Integer id);
	
	List<Filial>buscarTodos();

	boolean filialTemPessoa(Integer id);
}
