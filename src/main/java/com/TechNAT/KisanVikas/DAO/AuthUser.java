package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="UnauthroizeUser")
public class AuthUser {
	private String mobileno="";
	private String otp="";
	private String timestamp="";
	
	public AuthUser(String mobileno, String otp, String timestamp) {
		super();
		this.mobileno = mobileno;
		this.otp = otp;
		this.timestamp = timestamp;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "{\"mobileno\":\"" + mobileno + "\", otp\":\"" + otp + "\", timestamp\":\"" + timestamp + "}";
	}
	
}
