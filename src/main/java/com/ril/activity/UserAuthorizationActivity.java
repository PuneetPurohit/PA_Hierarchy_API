package com.ril.activity;

import java.util.List;

import com.ril.dto.ModuleMasterDto;

public interface UserAuthorizationActivity{
	
	public List<ModuleMasterDto> getAllModules(ModuleMasterDto moduleMasterDto);
	
}
