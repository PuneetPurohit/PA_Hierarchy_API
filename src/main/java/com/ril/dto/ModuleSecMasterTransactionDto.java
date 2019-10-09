package com.ril.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.ril.base.dto.AnalyticDto;

public class ModuleSecMasterTransactionDto extends AnalyticDto implements Serializable {

	private static final long serialVersionUID = -6260972436226305094L;
	private Long sectionId;
	private String sectionName;
	private Integer noOfTiles;
	private char isSectionActive;
	private ModuleMasterDto moduleMasterDto;
	private List<SectionTilesMasterTransactionDto> secTilesMasterTxDtos;

	public ModuleMasterDto getModuleMasterDto() {
		return moduleMasterDto;
	}

	public void setModuleMasterDto(ModuleMasterDto moduleMasterDto) {
		this.moduleMasterDto = moduleMasterDto;
	}

	public List<SectionTilesMasterTransactionDto> getSecTilesMasterTxDto() {
		return secTilesMasterTxDtos;
	}

	public void setSecTilesMasterTxDto(
			List<SectionTilesMasterTransactionDto> secTilesMasterTxDtos) {
		this.secTilesMasterTxDtos = secTilesMasterTxDtos;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getNoOfTiles() {
		return noOfTiles;
	}

	public void setNoOfTiles(Integer noOfTiles) {
		this.noOfTiles = noOfTiles;
	}

	public char getIsSectionActive() {
		return isSectionActive;
	}

	public void setIsSectionActive(char isSectionActive) {
		this.isSectionActive = isSectionActive;
	}

	@Override
	public String toString() {
		return "ModuleSecMasterTransactionDto [sectionId=" + sectionId
				+ ", sectionName=" + sectionName + ", noOfTiles=" + noOfTiles
				+ ", isSectionActive=" + isSectionActive + ", moduleMasterDto="
				+ moduleMasterDto + ", secTilesMasterTxDtos="
				+ secTilesMasterTxDtos + "]";
	}

	public ModuleSecMasterTransactionDto(Long sectionId, String sectionName,
			Integer noOfTiles, char isSectionActive) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.noOfTiles = noOfTiles;
		this.isSectionActive = isSectionActive;
	}

	public ModuleSecMasterTransactionDto(Long sectionId, String sectionName,
			Integer noOfTiles, char isSectionActive,
			ModuleMasterDto moduleMasterDto,
			List<SectionTilesMasterTransactionDto> secTilesMasterTxDtos) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.noOfTiles = noOfTiles;
		this.isSectionActive = isSectionActive;
		this.moduleMasterDto = moduleMasterDto;
		this.secTilesMasterTxDtos = secTilesMasterTxDtos;
	}

	public ModuleSecMasterTransactionDto() {

	}

}
