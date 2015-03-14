package cn.zale.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fc_alarm database table.
 * 
 */
@Entity
@Table(name="fc_alarm")
@NamedQuery(name="FcAlarm.findAll", query="SELECT f FROM FcAlarm f")
public class FcAlarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="alarm_id")
	private int alarmId;

	@Column(name="alarm_font")
	private String alarmFont;

	@Column(name="alarm_x")
	private int alarmX;

	@Column(name="alarm_y")
	private int alarmY;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private String attribute4;

	private String attribute5;

	@Column(name="building_id")
	private int buildingId;

	public FcAlarm() {
	}
	
	
	
	public FcAlarm(String alarm_font,int alarm_x,int alarm_y)
	{
		this.alarmFont = alarm_font;
		this.alarmX = alarm_x;
		this.alarmY = alarm_y;
	}

	public FcAlarm(int alarm_id,String alarm_font,int alarm_x,int alarm_y,int building_id) {
		this.alarmId = alarm_id;
		this.alarmFont = alarm_font;
		this.alarmX = alarm_x;
		this.alarmY = alarm_y;
		this.buildingId = building_id;
	}
	
	public int getAlarmId() {
		return this.alarmId;
	}

	public void setAlarmId(int alarmId) {
		this.alarmId = alarmId;
	}

	public String getAlarmFont() {
		return this.alarmFont;
	}

	public void setAlarmFont(String alarmFont) {
		this.alarmFont = alarmFont;
	}

	public int getAlarmX() {
		return this.alarmX;
	}

	public void setAlarmX(int alarmX) {
		this.alarmX = alarmX;
	}

	public int getAlarmY() {
		return this.alarmY;
	}

	public void setAlarmY(int alarmY) {
		this.alarmY = alarmY;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
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

	public int getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

}