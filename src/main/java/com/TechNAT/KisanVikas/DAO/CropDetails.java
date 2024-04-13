package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CropDetails")
public class CropDetails {

	private String cropid="";
	private String cropName;
	private String cropType="";
	private String DefaultColor="";
	private String ImageUrl="";
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
	public String getDefaultColor() {
		return DefaultColor;
	}
	public void setDefaultColor(String DefaultColor) {
		this.DefaultColor = DefaultColor;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String ImageUrl) {
		this.ImageUrl = ImageUrl;
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
				+ "\", DefaultColor\":\"" + DefaultColor + "\", ImageUrl\":\"" + ImageUrl + "\", stageofFamring\":\""
				+ stageofFamring + "\", selected\":\"" + selected + "}";
	}
	
	
}
