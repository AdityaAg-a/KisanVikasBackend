package com.TechNAT.KisanVikas.Service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.storage.GoogleStorageResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;
import com.google.cloud.storage.Storage;

import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class CropRecommendationTreeService {
	
	@Value("${gcs-resource-test-bucket}")
	private String bucketName;
	
	@Value("gs://${gcs-resource-test-bucket}/cropRecommendation/decisionCropRecommendation.model")
	 private Resource gcsFile;
	
	private Storage storage;

	private CropRecommendationTreeService(Storage storage) {
		this.storage = storage;
	}
	  
	public String PreditCropSuggesteed(CropRecommendation crp) {
		ObjectInputStream oos;
		try {
//			oos = new ObjectInputStream(new FileInputStream("https://storage.cloud.google.com/kisanvikas/cropRecommendation/decisionCropRecommendation.model"));
			Optional<String> str1=Optional.of("cropRecommendation/decisionCropRecommendation.model");
			storage.reader("",bucketName);
//			String str=StreamUtils.copyToString(
//					str1.isPresent()
//		                ? fetchResource(str1.get()).getInputStream()
//		                : this.gcsFile.getInputStream(),
//		            Charset.defaultCharset())
//		        + "\n";
			oos = new ObjectInputStream(new FileInputStream("src/main/resources/static/files/aimodel/decisionTree-minNumObj=2-Boosted=false-C=0.25-file=Crop_recommendation.model"));
			Classifier cls = (Classifier)oos.readObject();
			System.out.println("fetched file: ");
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
	
	private GoogleStorageResource fetchResource(String filename) {
	    return new GoogleStorageResource(
	        this.storage, String.format("gs://%s/%s", this.bucketName, filename));
	  }

}
