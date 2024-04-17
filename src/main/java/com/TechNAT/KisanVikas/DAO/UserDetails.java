package com.TechNAT.KisanVikas.DAO;

public class UserDetails {
	private String userName;
	private String userContactNumber;
	private String userAddress;
	private Location location;
	private UserCropsDetails userCropsDetails;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserContactNumber() {
		return userContactNumber;
	}
	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public UserCropsDetails getUserCropsDetails() {
		return userCropsDetails;
	}
	public void setUserCropsDetails(UserCropsDetails userCropsDetails) {
		this.userCropsDetails = userCropsDetails;
	}
	@Override
	public String toString() {
		return "{\"userName\":\"" + userName + "\",\" userContactNumber\":\"" + userContactNumber
				+ "\",\" userAddress\":\"" + userAddress + "\",\" location\":\"" + location + "\",\" cropsDetails\":\""
				+ userCropsDetails + "\"}";
	}
	

	// Getters and setters
	
	
}
