package com.jofre.sebd.dao;

import java.util.List;

import com.jofre.sebd.domain.Area;

public interface AreaDao {

	void save(Area area);
	
	void update(Area area);
	
	void delete(Integer id);
	
	Area findById(Integer id);
	
	List<Area>findAll();
	
}
