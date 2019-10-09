package com.ril.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="AAA_SECTION_TILE_MASTER_TX")
public class SectionTilesMasterTransaction implements Serializable{
	
	private static final long serialVersionUID = -7973667846546120955L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false,name="TILE_ID", columnDefinition="Integer(10)")
	private Long tileId;
	
	@Column(nullable = false,name="TILE_NAME", columnDefinition="NVARCHAR(50)")
	private String tileName;
	
	@Column(nullable = false,name="IS_TILE_ACTIVE", columnDefinition="CHAR(1)")
	private char isTileActive;
	
	@Column(nullable = false,name="TILE_END_POINT_URL", columnDefinition="NVARCHAR(150)")
	private String tileEndPointUrl;
	

	@ManyToOne
    @JoinColumn(name="SECTION_ID",nullable = false)
	private ModuleSecMasterTransaction moduleSecMasterTransaction;

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

	
	public ModuleSecMasterTransaction getModuleSecMasterTransaction() {
		return moduleSecMasterTransaction;
	}

	public void setModuleSecMasterTransaction(
			ModuleSecMasterTransaction moduleSecMasterTransaction) {
		this.moduleSecMasterTransaction = moduleSecMasterTransaction;
	}

	
	public String getTileEndPointUrl() {
		return tileEndPointUrl;
	}

	public void setTileEndPointUrl(String tileEndPointUrl) {
		this.tileEndPointUrl = tileEndPointUrl;
	}

	public SectionTilesMasterTransaction(){
		
	}

	
	public SectionTilesMasterTransaction(Long tileId, String tileName,
			char isTileActive, String tileEndPointUrl,
			ModuleSecMasterTransaction moduleSecMasterTransaction) {
		super();
		this.tileId = tileId;
		this.tileName = tileName;
		this.isTileActive = isTileActive;
		this.tileEndPointUrl = tileEndPointUrl;
		this.moduleSecMasterTransaction = moduleSecMasterTransaction;
	}

	@Override
	public String toString() {
		return "SectionTilesMasterTransaction [tileId=" + tileId
				+ ", tileName=" + tileName + ", isTileActive=" + isTileActive
				+ ", tileEndPointUrl=" + tileEndPointUrl
				+ ", moduleSecMasterTransaction=" + moduleSecMasterTransaction
				+ "]";
	}

}
