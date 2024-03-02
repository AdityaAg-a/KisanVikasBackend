package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="CropDetails")
public class CropDetails {

	private String cropid="";
	private String cropname;
	private String cropimgurl="";
	public String getCropid() {
		return cropid;
	}
	public void setCropid(String cropid) {
		this.cropid = cropid;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getCropimgurl() {
		return cropimgurl;
	}
	public void setCropimgurl(String cropimgurl) {
		this.cropimgurl = cropimgurl;
	}
	@Override
	public String toString() {
		return "{\"cropid\":\"" + cropid + "\", \"cropname\":\"" + cropname + "\", \"cropimgurl\":\"" + cropimgurl + "\"}";
	}
	
}
