package com.ril.dto;

import java.io.Serializable;

import com.ril.base.dto.AnalyticDto;

public class SectionTilesMasterTransactionDto extends AnalyticDto implements Serializable {

	private static final long serialVersionUID = -7973667846546120955L;
	private Long tileId;
	private String tileName;
	private char isTileActive;
	private String tileEndPointUrl;
	
	public String getTileEndPointUrl() {
		return tileEndPointUrl;
	}

	public void setTileEndPointUrl(String tileEndPointUrl) {
		this.tileEndPointUrl = tileEndPointUrl;
	}

	private ModuleSecMasterTransactionDto moduleSecMasterTransactionDto;

	public ModuleSecMasterTransactionDto getModuleSecMasterTransactionDto() {
		return moduleSecMasterTransactionDto;
	}

	public void setModuleSecMasterTransactionDto(
			ModuleSecMasterTransactionDto moduleSecMasterTransactionDto) {
		this.moduleSecMasterTransactionDto = moduleSecMasterTransactionDto;
	}

	public Long getTileId() {
		return tileId;
	}

	public void setTileId(Long tileId) {
		this.tileId = tileId;
	}

	public String getTileName() {
		return tileName;
	}

	public void setTileName(String tileName) {
		this.tileName = tileName;
	}

	public char getIsTileActive() {
		return isTileActive;
	}

	public void setIsTileActive(char isTileActive) {
		this.isTileActive = isTileActive;
	}

	public SectionTilesMasterTransactionDto() {

	}
	
	public SectionTilesMasterTransactionDto(Long tileId, String tileName,
			char isTileActive, String tileEndPointUrl,
			ModuleSecMasterTransactionDto moduleSecMasterTransactionDto) {
		super();
		this.tileId = tileId;
		this.tileName = tileName;
		this.isTileActive = isTileActive;
		this.tileEndPointUrl = tileEndPointUrl;
		this.moduleSecMasterTransactionDto = moduleSecMasterTransactionDto;
	}

	@Override
	public String toString() {
		return "SectionTilesMasterTransactionDto [tileId=" + tileId
				+ ", tileName=" + tileName + ", isTileActive=" + isTileActive
				+ ", tileEndPointUrl=" + tileEndPointUrl
				+ ", moduleSecMasterTransactionDto="
				+ moduleSecMasterTransactionDto + "]";
	}
	
}
