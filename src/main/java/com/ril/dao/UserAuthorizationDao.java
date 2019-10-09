package com.ril.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ril.entity.ModuleMaster;

public interface UserAuthorizationDao extends CrudRepository<ModuleMaster, Long>{

	public List<ModuleMaster> findAll(ModuleMaster moduleMaster);
	
}
