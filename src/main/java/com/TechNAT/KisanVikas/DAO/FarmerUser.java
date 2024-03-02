package com.TechNAT.KisanVikas.DAO;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FarmerUser")
public class FarmerUser {
	
	private String usrmobileno;
	private String authstatus="";
	private String usrname="";
	private String usrage="";
	private String[] usrlocation;
	private String[] usrcropid;
	private String usrsoilType;
	private String usrsoiltexture;
	public FarmerUser(String usrmobileno, String authstatus, String usrname, String usrage, String[] usrlocation,
			String[] usrcropid, String usrsoilType, String usrsoiltexture) {
		super();
		this.usrmobileno = usrmobileno;
		this.authstatus = authstatus;
		this.usrname = usrname;
		this.usrage = usrage;
		this.usrlocation = usrlocation;
		this.usrcropid = usrcropid;
		this.usrsoilType = usrsoilType;
		this.usrsoiltexture = usrsoiltexture;
	}
	public String getUsrmobileno() {
		return usrmobileno;
	}
	public void setUsrmobileno(String usrmobileno) {
		this.usrmobileno = usrmobileno;
	}
	public String getAuthstatus() {
		return authstatus;
	}
	public void setAuthstatus(String authstatus) {
		this.authstatus = authstatus;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsrage() {
		return usrage;
	}
	public void setUsrage(String usrage) {
		this.usrage = usrage;
	}
	public String[] getUsrlocation() {
		return usrlocation;
	}
	public void setUsrlocation(String[] usrlocation) {
		this.usrlocation = usrlocation;
	}
	public String[] getUsrcropid() {
		return usrcropid;
	}
	public void setUsrcropid(String[] usrcropid) {
		this.usrcropid = usrcropid;
	}
	public String getUsrsoilType() {
		return usrsoilType;
	}
	public void setUsrsoilType(String usrsoilType) {
		this.usrsoilType = usrsoilType;
	}
	public String getUsrsoiltexture() {
		return usrsoiltexture;
	}
	public void setUsrsoiltexture(String usrsoiltexture) {
		this.usrsoiltexture = usrsoiltexture;
	}
	
	
	

}
