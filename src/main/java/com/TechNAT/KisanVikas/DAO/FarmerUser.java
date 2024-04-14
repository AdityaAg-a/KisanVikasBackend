package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FarmerUser")
public class FarmerUser {
	@Id
	private String id;

	private LoginDetails loginDetails;
	private UserDetails userDetails;
	private Farminfo farminfo;
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
	public Farminfo getFarminfo() {
		return farminfo;
	}
	public void setFarminfo(Farminfo farminfo) {
		this.farminfo = farminfo;
	}
	
	
}

class LoginDetails {
	private String userid;
	private boolean isVerified;
	private String timeStamp;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}

class UserDetails {
	private String userName;
	private String userContactNumber;
	private String userAddress;
	private Location location;
	private CropsDetails cropsDetails;
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
	public CropsDetails getCropsDetails() {
		return cropsDetails;
	}
	public void setCropsDetails(CropsDetails cropsDetails) {
		this.cropsDetails = cropsDetails;
	}

	// Getters and setters
	
	
}

class Location {
	private double latitude;
	private double longitude;
	private String userCity;
	private String userState;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}

	
	
}

class CropsDetails {
	private String allCrops;
	private String selectedCrops;
	public String getAllCrops() {
		return allCrops;
	}
	public void setAllCrops(String allCrops) {
		this.allCrops = allCrops;
	}
	public String getSelectedCrops() {
		return selectedCrops;
	}
	public void setSelectedCrops(String selectedCrops) {
		this.selectedCrops = selectedCrops;
	}

	
}

class Farminfo {
	private String fieldSize;
	private String fieldSizeUnit;
	private String nValue;
	private String pValue;
	private String kValue;
	private String soilColor;
	private String soilType;
	private String fieldHumidity;
	private String fieldRainfall;
	public String getFieldSize() {
		return fieldSize;
	}
	public void setFieldSize(String fieldSize) {
		this.fieldSize = fieldSize;
	}
	public String getFieldSizeUnit() {
		return fieldSizeUnit;
	}
	public void setFieldSizeUnit(String fieldSizeUnit) {
		this.fieldSizeUnit = fieldSizeUnit;
	}
	public String getnValue() {
		return nValue;
	}
	public void setnValue(String nValue) {
		this.nValue = nValue;
	}
	public String getpValue() {
		return pValue;
	}
	public void setpValue(String pValue) {
		this.pValue = pValue;
	}
	public String getkValue() {
		return kValue;
	}
	public void setkValue(String kValue) {
		this.kValue = kValue;
	}
	public String getSoilColor() {
		return soilColor;
	}
	public void setSoilColor(String soilColor) {
		this.soilColor = soilColor;
	}
	public String getSoilType() {
		return soilType;
	}
	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}
	public String getFieldHumidity() {
		return fieldHumidity;
	}
	public void setFieldHumidity(String fieldHumidity) {
		this.fieldHumidity = fieldHumidity;
	}
	public String getFieldRainfall() {
		return fieldRainfall;
	}
	public void setFieldRainfall(String fieldRainfall) {
		this.fieldRainfall = fieldRainfall;
	}
	
}
