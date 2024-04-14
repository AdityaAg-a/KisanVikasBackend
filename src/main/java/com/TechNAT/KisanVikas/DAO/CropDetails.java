package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CropDetails")
public class CropDetails {

	private String cropid="";
	private String cropName;
	private String cropType="";
	private String defaultColor="";
	private String imageUrl="";
	private String stageofFamring="";
	private Boolean selected=false;
	public String getCropid() {
		return cropid;
	}
	public void setCropid(String cropid) {
		this.cropid = cropid;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getdefaultColor() {
		return defaultColor;
	}
	public void setdefaultColor(String defaultColor) {
		this.defaultColor = defaultColor;
	}
	public String getimageUrl() {
		return imageUrl;
	}
	public void setimageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStageofFamring() {
		return stageofFamring;
	}
	public void setStageofFamring(String stageofFamring) {
		this.stageofFamring = stageofFamring;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	@Override
	public String toString() {
		return "{\"cropid\":\"" + cropid + "\", cropName\":\"" + cropName + "\", cropType\":\"" + cropType
				+ "\", defaultColor\":\"" + defaultColor + "\", imageUrl\":\"" + imageUrl + "\", stageofFamring\":\""
				+ stageofFamring + "\", selected\":\"" + selected + "}";
	}
	
	
}
