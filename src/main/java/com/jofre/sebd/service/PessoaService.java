package com.jofre.sebd.service;

import java.util.List;

import com.jofre.sebd.domain.Pessoa;

public interface PessoaService {
	
void salvar(Pessoa pessoa);
	
	void editar(Pessoa pessoa);
	
	void excluir(Integer id);
	
	Pessoa buscarPorId(Integer id);
	
	List<Pessoa>buscarTodos();

	List<Pessoa>buscarPorNome(String nome);

	List<Pessoa> buscarPorFilial(Integer id);

	List<Pessoa>buscarPorCartao(Long cartaoMembro);

	List<Pessoa>buscarPorTelefone(String telefone);

}
