package com.TechNAT.KisanVikas.Service;


import java.io.StringReader;

import org.dmg.pmml.PMML;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xml.sax.InputSource;

import jakarta.xml.bind.JAXBException;

@Configuration
public class CropRecommendationImpl {

	@Bean
	public PMML loadModel() throws JAXBException{
		try {
			String path="/src/main/resources/static/crop_prediction_model.pmml";
			InputSource source = new InputSource(new StringReader(path));
			System.out.println(source);
	        return new PMML();  // Create PMMLModel instance
	    } catch (Exception e) {
	        throw new RuntimeException("Error loading PMML model", e);
	    }
	}
}
