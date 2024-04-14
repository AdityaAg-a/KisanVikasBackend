package com.TechNAT.KisanVikas.DAO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "cropDiseases")
public class CropDiseases {
    @Id
    private String id;
    private String diseaseName;
    private String diseaseInfo;
    private List<String> tags;
    private String imgUrl;
    private String treatment;
    private String modelresult;
    private String cropname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseInfo() {
		return diseaseInfo;
	}
	public void setDiseaseInfo(String diseaseInfo) {
		this.diseaseInfo = diseaseInfo;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getModelResult() {
		return modelresult;
	}
	public void setModelResult(String modelresult) {
		this.modelresult = modelresult;
	}
	public String getCropName() {
		return cropname;
	}
	public void setCropName(String cropname) {
		this.cropname = cropname;
	}

    
}