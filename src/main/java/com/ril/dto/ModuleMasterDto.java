package com.ril.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.ril.base.dto.AnalyticDto;

public class ModuleMasterDto extends AnalyticDto implements Serializable {

	private static final long serialVersionUID = 8823778879239482692L;
	private Long moduleId;
	private String moduleType;
	private String moduleName;
	private String moduleDescription;
	private char isModuleActive;
	private Integer noOfSections;
	private List<ModuleSecMasterTransactionDto> modSecMasterTxDtos;
	private String partnerRoleType;
	private String parentRoleType;
	private String partnerRoleName;
	private String parentRoleName;

	public List<ModuleSecMasterTransactionDto> getModSecMasterTxDtos() {
		return modSecMasterTxDtos;
	}

	public void setModSecMasterTxDtos(
			List<ModuleSecMasterTransactionDto> modSecMasterTxDtos) {
		this.modSecMasterTxDtos = modSecMasterTxDtos;
	}

	public String getPartnerRoleType() {
		return partnerRoleType;
	}

	public void setPartnerRoleType(String partnerRoleType) {
		this.partnerRoleType = partnerRoleType;
	}

	public String getParentRoleType() {
		return parentRoleType;
	}

	public void setParentRoleType(String parentRoleType) {
		this.parentRoleType = parentRoleType;
	}

	public String getPartnerRoleName() {
		return partnerRoleName;
	}

	public void setPartnerRoleName(String partnerRoleName) {
		this.partnerRoleName = partnerRoleName;
	}

	public String getParentRoleName() {
		return parentRoleName;
	}

	public void setParentRoleName(String parentRoleName) {
		this.parentRoleName = parentRoleName;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public char getIsModuleActive() {
		return isModuleActive;
	}

	public void setIsModuleActive(char isModuleActive) {
		this.isModuleActive = isModuleActive;
	}

	public Integer getNoOfSections() {
		return noOfSections;
	}

	public void setNoOfSections(Integer noOfSections) {
		this.noOfSections = noOfSections;
	}

	public ModuleMasterDto() {

	}

	public ModuleMasterDto(Long moduleId, String moduleType, String moduleName,
			String moduleDescription, char isModuleActive,
			Integer noOfSections,
			List<ModuleSecMasterTransactionDto> modSecMasterTxDtos,
			String partnerRoleType, String parentRoleType,
			String partnerRoleName, String parentRoleName) {
		super();
		this.moduleId = moduleId;
		this.moduleType = moduleType;
		this.moduleName = moduleName;
		this.moduleDescription = moduleDescription;
		this.isModuleActive = isModuleActive;
		this.noOfSections = noOfSections;
		this.modSecMasterTxDtos = modSecMasterTxDtos;
		this.partnerRoleType = partnerRoleType;
		this.parentRoleType = parentRoleType;
		this.partnerRoleName = partnerRoleName;
		this.parentRoleName = parentRoleName;
	}

	
}
