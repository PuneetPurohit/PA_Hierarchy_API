package com.ril.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;

import com.google.gson.Gson;
import com.ril.dto.ModuleMasterDto;
import com.ril.dto.ModuleSecMasterTransactionDto;
import com.ril.dto.SectionTilesMasterTransactionDto;
import com.ril.entity.ModuleMaster;
import com.ril.entity.ModuleSecMasterTransaction;
import com.ril.entity.SectionTilesMasterTransaction;

public class CommonUtil {

	private static Gson gson = new Gson();

	public static <T> T getPojoFromJson(String jsonString, Class<T> classType) {
		T t = gson.fromJson(jsonString, classType);
		return t;
	}

	public static <T> String addArgumentInMessage(String message,
			List<T> arguments) {
		int i = 0;
		if (!CollectionUtils.isEmpty(arguments)) {
			for (T paraString : arguments) {
				String pattern = "{" + i + "}";
				message = message.replace(pattern, paraString.toString());
				i++;
			}
		}
		return message;
	}
	
	public static ModuleMaster convertDtoToEntityModules(ModuleMasterDto dto) {
		ModuleMaster module = new ModuleMaster();
		
		if (module != null) {
			module.setPartnerRoleType(dto.getPartnerRoleType());
		}
		return module;
	}

	public static List<ModuleMasterDto> convertEntityToDtoModules(List<ModuleMaster> moduleMaster) {
		List<ModuleMasterDto> moduleDtos = new ArrayList<ModuleMasterDto>();
		try {
			//List<ModuleMasterDto> moduleDtos = new ArrayList<ModuleMasterDto>();
			
			for (ModuleMaster module : moduleMaster) {
				ModuleMasterDto userMasterDto = new ModuleMasterDto();
				
				userMasterDto.setModuleId(module.getModuleId());
				userMasterDto.setModuleName(module.getModuleName());
				//userMasterDto.setModuleType(module.getModuleType());
				userMasterDto.setParentRoleName(module.getParentRoleName());
				userMasterDto.setParentRoleType(module.getParentRoleType());
				userMasterDto.setPartnerRoleName(module.getPartnerRoleName());
				userMasterDto.setPartnerRoleType(module.getPartnerRoleType());
				userMasterDto.setNoOfSections(module.getNoOfSections());
				userMasterDto.setIsModuleActive(module.getIsModuleActive());
				List<ModuleSecMasterTransaction> sec = module.getModSecMasterTx();
				List<ModuleSecMasterTransactionDto> secs = new ArrayList<ModuleSecMasterTransactionDto>();
				
				for (ModuleSecMasterTransaction section : sec) {
					ModuleSecMasterTransactionDto secMasterDto = new ModuleSecMasterTransactionDto();
					
					secMasterDto.setSectionId(section.getSectionId());
					secMasterDto.setSectionName(section.getSectionName());
					secMasterDto.setNoOfTiles(section.getNoOfTiles());
					secMasterDto.setIsSectionActive(section.getIsSectionActive());
					List<SectionTilesMasterTransaction> tiles = section.getSecTilesMasterTx();
					List<SectionTilesMasterTransactionDto> tileDtos = new ArrayList<SectionTilesMasterTransactionDto>();
					
					for (SectionTilesMasterTransaction tile : tiles) {
						SectionTilesMasterTransactionDto tilesDto = new SectionTilesMasterTransactionDto();
						tilesDto.setTileId(tile.getTileId());
						tilesDto.setTileName(tile.getTileName());
						tilesDto.setTileEndPointUrl(tile.getTileEndPointUrl());
						tilesDto.setIsTileActive(tile.getIsTileActive());
						tileDtos.add(tilesDto);
					}
					secMasterDto.setSecTilesMasterTxDto(tileDtos);
					secs.add(secMasterDto);
				}
				
				userMasterDto.setModSecMasterTxDtos(secs);
				
				moduleDtos.add(userMasterDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return moduleDtos;
	}
	
	@SuppressWarnings("serial")
	public static HttpHeaders createHeaders(String username, String password) {
		HttpHeaders acceptHeaders = new HttpHeaders() {
			{
				//set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
			}
		};
		String authorization = username + ":" + password;
		String basic = new String(Base64.getEncoder().encodeToString(
				(authorization.getBytes(Charset.forName("US-ASCII")))));
		acceptHeaders.set("Authorization", "Basic " + basic);

		return acceptHeaders;
	}
}
