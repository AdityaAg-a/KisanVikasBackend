package com.TechNAT.KisanVikas.DAO;

public class Location {
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
	@Override
	public String toString() {
		return "{\"latitude\":\"" + latitude + "\",\" longitude\":\"" + longitude + "\",\" userCity\":\"" + userCity
				+ "\",\" userState\":\"" + userState + "\"}";
	}

	
	
}