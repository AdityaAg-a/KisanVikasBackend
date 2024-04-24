package com.TechNAT.KisanVikas.Service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Reader;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class CropRecommendationTreeService {
	
	public String PreditCropSuggesteed(CropRecommendation crp) {
		ObjectInputStream oos;
		try {
			oos = new ObjectInputStream(new FileInputStream("src/main/resources/models/decisionTree-minNumObj=2-Boosted=false-C=0.25-file=Crop_recommendation.model"));
			Classifier cls = (Classifier)oos.readObject();
			System.out.println("fetched file");
//			Instances dataa ;
//	        dataa.setClassIndex(dataa.numAttributes() - 1); // Set class attribute
//
//	        // Create an empty instance with attributes
//	        Instance instance = new DenseInstance(8); // 7 is the number of attributes
//	        instance.setDataset(dataa);
//	        instance.setValue(dataa.attribute("N"), Integer.parseInt(crp.getN()));
//	        instance.setValue(dataa.attribute("P"), Integer.parseInt(crp.getP()));
//	        instance.setValue(dataa.attribute("K"), Integer.parseInt(crp.getK()));
//	        instance.setValue(dataa.attribute("temperature"), Integer.parseInt(crp.getTemperature()));
//	        instance.setValue(dataa.attribute("humidity"), Integer.parseInt(crp.getHumidity()));
//	        instance.setValue(dataa.attribute("ph"), Integer.parseInt(crp.getPh()));
//	        instance.setValue(dataa.attribute("rainfall"), Integer.parseInt(crp.getRainfall()));
			oos.close();
			return cls.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	

}
