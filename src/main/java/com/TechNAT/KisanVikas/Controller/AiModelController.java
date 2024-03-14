package com.TechNAT.KisanVikas.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TechNAT.KisanVikas.DAO.CropRecommendation;

@RestController
public class AiModelController {

	
	@PostMapping("/cropRecommendation")
	public String CropRecommendation(@RequestBody CropRecommendation crp) {
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "Crop Cannot Be suggested right now!";
	}
}
