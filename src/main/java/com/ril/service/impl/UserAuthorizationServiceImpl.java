package com.ril.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ril.activity.UserAuthorizationActivity;
import com.ril.dto.ModuleMasterDto;
import com.ril.service.UserAuthorizationService;

@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {

	@Autowired
	private UserAuthorizationActivity userAuthorizationActivity;

	public UserAuthorizationActivity getUserAuthorizationActivity() {
		return userAuthorizationActivity;
	}

	public void setUserAuthorizationActivity(
			UserAuthorizationActivity userAuthorizationActivity) {
		this.userAuthorizationActivity = userAuthorizationActivity;
	}
	
	@Override
	public List<ModuleMasterDto> getAllAuthEndPointUrls(ModuleMasterDto moduleMasterDto){
		List<ModuleMasterDto> moduleMaster= null;
		try {
			moduleMaster= userAuthorizationActivity.getAllModules(moduleMasterDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return moduleMaster;
	}

}
