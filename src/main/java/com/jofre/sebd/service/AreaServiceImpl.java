package com.jofre.sebd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jofre.sebd.dao.AreaDao;
import com.jofre.sebd.domain.Area;

@Service
@Transactional(readOnly = false)
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao dao;
	
	@Override
	public void salvar(Area area) {
		dao.save(area);
		
	}

	@Override
	public void editar(Area area) {
		dao.update(area);		
	}

	@Override 
	public void excluir(Integer id) {
		dao.delete(id);
		
	}
	
	@Override
	public Area buscarPorId(Integer id) {
		
		return dao.findById(id);
	}

	
	@Override 
	@Transactional(readOnly = true)
	public List<Area> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean areaTemCongregacao(Integer id) {
		if(buscarPorId(id).getCongregacoes().isEmpty()) {
			return false;
		}
		return true;
	}

	
}
