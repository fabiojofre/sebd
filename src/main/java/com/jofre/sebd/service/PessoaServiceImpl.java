package com.jofre.sebd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.sebd.dao.PessoaDao;
import com.jofre.sebd.domain.Pessoa;

@Service
@Transactional(readOnly = false)
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaDao dao;
	
	@Override
	public void salvar(Pessoa pessoa) {
		dao.save(pessoa);
		
	}

	@Override
	public void editar(Pessoa pessoa) {
		dao.update(pessoa);
		
	}

	@Override
	public void excluir(Integer id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Pessoa buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Pessoa> buscarTodos() {
	
		return dao.findAll();
	}

}
