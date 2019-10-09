package com.ril.activity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.activity.UserAuthorizationActivity;
import com.ril.dao.UserAuthorizationDao;
import com.ril.dto.ModuleMasterDto;
import com.ril.entity.ModuleMaster;
import com.ril.util.CommonUtil;
@Service
@Transactional
public class UserAuthorizationActivityImpl implements UserAuthorizationActivity {

	@Autowired
	private UserAuthorizationDao userAuthorizationDao;

	
	public UserAuthorizationDao getUserAuthorizationDao() {
		return userAuthorizationDao;
	}

	public void setUserAuthorizationDao(UserAuthorizationDao userAuthorizationDao) {
		this.userAuthorizationDao = userAuthorizationDao;
	}

	@Override
	public List<ModuleMasterDto> getAllModules(ModuleMasterDto moduleMasterDto) {

		List<ModuleMasterDto> moduleDto = new ArrayList<ModuleMasterDto>();
		List<ModuleMaster> modules=new ArrayList<ModuleMaster>();
		// convert dto to entity
		ModuleMaster moduleMaster = CommonUtil.convertDtoToEntityModules(moduleMasterDto);
		if (moduleMaster != null) {
			
			modules = userAuthorizationDao.findAll(moduleMaster);
		}

		if (moduleMaster != null) {
			// convert entity to dto
			moduleDto = CommonUtil.convertEntityToDtoModules(modules);
		}
		return moduleDto;
	
	}

}
