package com.TechNAT.KisanVikas.DAO;

public class UserCropsDetails {
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
	@Override
	public String toString() {
		return "{\"allCrops\":\"" + allCrops + "\",\" selectedCrops\":\"" + selectedCrops + "\"}";
	}

	
}