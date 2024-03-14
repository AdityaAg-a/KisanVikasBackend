package com.TechNAT.KisanVikas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;
import com.TechNAT.KisanVikas.Service.AiModel.CropPredictionService;

@RestController
public class AiModelController {

	@Autowired
	private CropPredictionService cropprediction;
	@PostMapping("/cropRecommendation")
	public String CropRecommendation(@RequestBody CropRecommendation crp) {
		try {
			String a=cropprediction.predictCrop(crp);
			return a;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Crop Cannot Be suggested right now!";
	}
}
