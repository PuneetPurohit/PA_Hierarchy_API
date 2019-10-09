package com.ril.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AAA_MODULE_MASTER")
public class ModuleMaster implements Serializable {

	private static final long serialVersionUID = 8823778879239482692L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "MODULE_ID", columnDefinition = "Integer(5)")
	private Long moduleId;

	/*@Column(nullable = false, name = "MODULE_TYPE", columnDefinition = "NVARCHAR(20)")
	private String moduleType;*/

	@Column(nullable = false, name = "MODULE_NAME", columnDefinition = "NVARCHAR(50)")
	private String moduleName;

	/*@Column(name = "MODULE_DESCR", columnDefinition = "NVARCHAR(100)")
	private String moduleDescription;*/

	@Column(nullable = false, name = "IS_MODULE_ACTIVE", columnDefinition = "CHAR(1)")
	private char isModuleActive;

	@Column(nullable = false, name = "NO_OF_SECTION", columnDefinition = "Integer(3)")
	private Integer noOfSections;

	@OneToMany(mappedBy = "moduleMaster", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<ModuleSecMasterTransaction> modSecMasterTx;
	
	@Column(nullable = false, name = "PARTNER_ROLE_TYPE", columnDefinition = "NVARCHAR(20)")
	private String partnerRoleType;

	@Column(name = "PARENT_ROLE_TYPE", columnDefinition = "NVARCHAR2(50)")
	private String parentRoleType;

	@Column(nullable = false, name = "PARTNER_ROLE_NAME", columnDefinition = "NVARCHAR(50)")
	private String partnerRoleName;
	
	@Column(name = "PARENT_ROLE_NAME", columnDefinition = "NVARCHAR(50)")
	private String parentRoleName;


	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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

	public List<ModuleSecMasterTransaction> getModSecMasterTx() {
		return modSecMasterTx;
	}

	public void setModSecMasterTx(List<ModuleSecMasterTransaction> modSecMasterTx) {
		this.modSecMasterTx = modSecMasterTx;
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

	public ModuleMaster(){
		
	}
	
	public ModuleMaster(Long moduleId, String moduleType, String moduleName,
			String moduleDescription, char isModuleActive,
			Integer noOfSections,
			List<ModuleSecMasterTransaction> modSecMasterTx,
			String partnerRoleType, String parentRoleType,
			String partnerRoleName, String parentRoleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.isModuleActive = isModuleActive;
		this.noOfSections = noOfSections;
		this.modSecMasterTx = modSecMasterTx;
		this.partnerRoleType = partnerRoleType;
		this.parentRoleType = parentRoleType;
		this.partnerRoleName = partnerRoleName;
		this.parentRoleName = parentRoleName;
	}

	@Override
	public String toString() {
		return "ModuleMaster [moduleId=" + moduleId + " moduleName=" + moduleName
				+ ", isModuleActive=" + isModuleActive + ", noOfSections="
				+ noOfSections + ", modSecMasterTx=" + modSecMasterTx
				+ ", partnerRoleType=" + partnerRoleType + ", parentRoleType="
				+ parentRoleType + ", partnerRoleName=" + partnerRoleName
				+ ", parentRoleName=" + parentRoleName + "]";
	}

	

}
