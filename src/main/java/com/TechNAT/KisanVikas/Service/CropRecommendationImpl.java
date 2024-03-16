package com.TechNAT.KisanVikas.Service;

import java.io.InputStream;
import java.io.ObjectInputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;


@Component
public class CropRecommendationImpl {
	
//	private  RandomForestClassifier rfClassifier;
//	public CropRecommendationImpl() {
//        try {
//            // Load the model from the resources directory
//            Resource resource = new ClassPathResource("rf_classifier.pkl");
//            InputStream inputStream = resource.getInputStream();
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//
//            // Deserialize the model
//            rfClassifier = (RandomForestClassifier) objectInputStream.readObject();
//
//            objectInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//	public String CropRecommenation(CropRecommendation crp) throws Exception {
//		try {
//			String[] crops = {"Wheat", "Rice", "Maize", "Soybean", "Cotton", "Barley"}; // Example crops
//
//	        // Make prediction using the loaded model
//	        int predictedIndex = rfClassifier.predict(new double[][]{crp})[0];
//	        return crops[predictedIndex];
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
	
}
