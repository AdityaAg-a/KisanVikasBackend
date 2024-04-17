package com.TechNAT.KisanVikas.DAO;

public class UserFarminfo {
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
	public String getNValue() {
		return nValue;
	}
	public void setnValue(String nValue) {
		this.nValue = nValue;
	}
	public String getPValue() {
		return pValue;
	}
	public void setpValue(String pValue) {
		this.pValue = pValue;
	}
	public String getKValue() {
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
	@Override
	public String toString() {
		return "{\"fieldSize\":\"" + fieldSize + "\",\" fieldSizeUnit\":\"" + fieldSizeUnit + "\",\" nValue\":\""
				+ nValue + "\",\" pValue\":\"" + pValue + "\",\" kValue\":\"" + kValue + "\",\" soilColor\":\""
				+ soilColor + "\",\" soilType\":\"" + soilType + "\",\" fieldHumidity\":\"" + fieldHumidity
				+ "\",\" fieldRainfall\":\"" + fieldRainfall + "\"}";
	}
	
	
}