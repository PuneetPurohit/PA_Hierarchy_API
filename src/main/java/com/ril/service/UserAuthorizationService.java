package com.ril.service;

import java.util.List;

import com.ril.dto.ModuleMasterDto;

public interface UserAuthorizationService{
	
	public List<ModuleMasterDto> getAllAuthEndPointUrls(ModuleMasterDto moduleMasterDto);
	
}
