package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="SoilType")
public class SoilType {

	private String soilid;
	private String soilname;
	public SoilType(String soilname, String soilid) {
		super();
		this.soilname = soilname;
		this.soilid = soilid;
	}
	public String getSoilname() {
		return soilname;
	}
	public void setSoilname(String soilname) {
		this.soilname = soilname;
	}
	public String getSoilid() {
		return soilid;
	}
	public void setSoilid(String soilid) {
		this.soilid = soilid;
	}
	
}
