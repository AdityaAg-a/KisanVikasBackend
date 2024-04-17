package com.TechNAT.KisanVikas.DAO;

public class LoginDetails {
	private String userid;
	private boolean isVerified;
	private String timeStamp;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean getisVerified() {
		return isVerified;
	}
	public void setisVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "{\"userid\":\"" + userid + "\",\" isVerified\":\"" + isVerified + "\",\" timeStamp\":\"" + timeStamp
				+ "\"}";
	}
	

	
}
