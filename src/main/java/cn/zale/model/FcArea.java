package cn.zale.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fc_area database table.
 * 
 */
@Entity
@Table(name="fc_area")
@NamedQuery(name="FcArea.findAll", query="SELECT f FROM FcArea f")
public class FcArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="area_id")
	private int areaId;

	@Column(name="area_chinese")
	private String areaChinese;

	@Column(name="area_name")
	private String areaName;

	@Lob
	@Column(name="area_pic")
	private byte[] areaPic;

	private String attribute2;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	
	
	public FcArea() {
	}
	
	public FcArea(int areaId,String areaName,String areaChinese) {
		this.areaId = areaId;
		this.areaName = areaName;
		this.areaChinese = areaChinese;
	}

	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaChinese() {
		return this.areaChinese;
	}

	public void setAreaChinese(String areaChinese) {
		this.areaChinese = areaChinese;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public byte[] getAreaPic() {
		return this.areaPic;
	}

	public void setAreaPic(byte[] areaPic) {
		this.areaPic = areaPic;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
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

}