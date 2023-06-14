package com.jofre.sebd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.sebd.dao.FilialDao;
import com.jofre.sebd.domain.Filial;

@Service
@Transactional(readOnly = false)
public class FilialServiceImpl implements FilialService {

	@Autowired
	private FilialDao dao;
	
	@Override
	public void salvar(Filial filial) {
		dao.save(filial);
		
	}

	@Override
	public void editar(Filial filial) {
		dao.update(filial);		
	}

	@Override 
	public void excluir(Integer id) {
		dao.delete(id);
		
	}
	
	@Override @Transactional(readOnly = true)
	public Filial buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	
	@Override 
	@Transactional(readOnly = true)
	public List<Filial> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean filialTemPessoa(Integer id) {
		if(buscarPorId(id).getPessoas().isEmpty()) {
			return false;
		}
		return true;
	}

	
}
