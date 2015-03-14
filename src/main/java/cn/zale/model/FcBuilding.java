package cn.zale.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fc_building database table.
 * 
 */
@Entity
@Table(name="fc_building")
@NamedQuery(name="FcBuilding.findAll", query="SELECT f FROM FcBuilding f")
public class FcBuilding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="building_id")
	private int buildingId;

	@Column(name="area_id")
	private int areaId;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	@Column(name="building_number")
	private int buildingNumber;

	@Lob
	@Column(name="building_pic")
	private byte[] buildingPic;

	@Column(name="building_x")
	private int buildingX;

	@Column(name="building_y")
	private int buildingY;

	public FcBuilding() {
	}
	
	public FcBuilding(int buildingId,int area_id,int buildingNumber)
	{
		this.buildingId = buildingId;
		this.areaId = area_id;
		this.buildingNumber = buildingNumber;
	}

	
	public FcBuilding(int buildingId,int area_id,int buildingNumber,int buildingX,int buildingY)
	{
		this.buildingId = buildingId;
		this.areaId = area_id;
		this.buildingNumber = buildingNumber;
		this.buildingX = buildingX;
		this.buildingY = buildingY;
	}
	
	public int getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return this.attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public int getBuildingNumber() {
		return this.buildingNumber;
	}

	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public byte[] getBuildingPic() {
		return this.buildingPic;
	}

	public void setBuildingPic(byte[] buildingPic) {
		this.buildingPic = buildingPic;
	}

	public int getBuildingX() {
		return this.buildingX;
	}

	public void setBuildingX(int buildingX) {
		this.buildingX = buildingX;
	}

	public int getBuildingY() {
		return this.buildingY;
	}

	public void setBuildingY(int buildingY) {
		this.buildingY = buildingY;
	}

}