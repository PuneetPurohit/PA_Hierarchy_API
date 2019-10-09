package com.ril.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AAA_MODULE_SECTION_MASTER_TX")
public class ModuleSecMasterTransaction implements Serializable {

	private static final long serialVersionUID = -6260972436226305094L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "SECTION_ID", columnDefinition = "Integer(5)")
	private Long sectionId;

	@Column(nullable = false, name = "SECTION_NAME", columnDefinition = "NVARCHAR(50)")
	private String sectionName;

	@Column(nullable = false, name = "NO_OF_TILES", columnDefinition = "Integer(3)")
	private Integer noOfTiles;

	@Column(nullable = false, name = "IS_SECTION_ACTIVE", columnDefinition = "CHAR(1)")
	private char isSectionActive;

	@ManyToOne
	@JoinColumn(name = "MODULE_ID", nullable = false)
	private ModuleMaster moduleMaster;

	@OneToMany(mappedBy = "moduleSecMasterTransaction", cascade = CascadeType.ALL)
	private List<SectionTilesMasterTransaction> secTilesMasterTx;

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

	public ModuleMaster getModuleMaster() {
		return moduleMaster;
	}

	public void setModuleMaster(ModuleMaster moduleMaster) {
		this.moduleMaster = moduleMaster;
	}

	public List<SectionTilesMasterTransaction> getSecTilesMasterTx() {
		return secTilesMasterTx;
	}

	public void setSecTilesMasterTx(
			List<SectionTilesMasterTransaction> secTilesMasterTx) {
		this.secTilesMasterTx = secTilesMasterTx;
	}

	@Override
	public String toString() {
		return "ModuleSecMasterTransaction [sectionId=" + sectionId
				+ ", sectionName=" + sectionName + ", noOfTiles=" + noOfTiles
				+ ", isSectionActive=" + isSectionActive + ", moduleId="
				+ moduleMaster + ", secTilesMasterTx=" + secTilesMasterTx + "]";
	}

	public ModuleSecMasterTransaction(Long sectionId, String sectionName,
			Integer noOfTiles, char isSectionActive, ModuleMaster moduleMaster,
			List<SectionTilesMasterTransaction> secTilesMasterTx) {
		super();
		this.sectionId = sectionId;
		this.sectionName = sectionName;
		this.noOfTiles = noOfTiles;
		this.isSectionActive = isSectionActive;
		this.moduleMaster = moduleMaster;
		this.secTilesMasterTx = secTilesMasterTx;
	}

	public ModuleSecMasterTransaction() {

	}

}
