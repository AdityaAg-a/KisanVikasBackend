package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FarmerUser")
public class FarmerUser {
	@Id
	private String id;

	private LoginDetails loginDetails;
	private UserDetails userDetails;
	private UserFarminfo userfarminfo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}
	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public UserFarminfo getUserfarminfo() {
		return userfarminfo;
	}
	public void setUserfarminfo(UserFarminfo userfarminfo) {
		this.userfarminfo = userfarminfo;
	}
	

	
	
}


