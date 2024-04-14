package com.TechNAT.KisanVikas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TechNAT.KisanVikas.DAO.CropDetails;
import com.TechNAT.KisanVikas.DAO.CropDiseases;
import com.TechNAT.KisanVikas.DAO.SoilType;
import com.TechNAT.KisanVikas.Repositories.CropDiseasesRepository;
import com.TechNAT.KisanVikas.Repositories.CropRepository;
import com.TechNAT.KisanVikas.Repositories.SoilTypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/Info")
public class InfoController {

	@Autowired
	private SoilTypeRepository soiltyperepository;
	
	@Autowired
	private CropRepository croprepository;
	
	@Autowired
	private CropDiseasesRepository cropdiseasesrepo;
	
	@GetMapping("getSoilName")
	public String getSoilName(@RequestParam String soilId) {
		String soilname=""; 
		Optional<SoilType> soilDetails=this.soiltyperepository.findById(soilId);
		System.out.println(soilDetails);
		return soilname;
	}
	
	@GetMapping("getAllCrops")
	public String getAllCrops() {
		List<CropDetails> cropdetailslist=this.croprepository.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
            return objectMapper.writeValueAsString(cropdetailslist);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error occurred while processing JSON";
        }
	}
	
	@PostMapping("setCropDetails")
	public String setCropDetails(@RequestBody CropDetails cropdetails) {
		String msg="";
		
		try {
 
			this.croprepository.save(cropdetails);
			System.out.println(cropdetails.toString());
			msg="Sccessfully added New Crop";
		}
		catch(Exception e) {
			e.printStackTrace();
			msg="Exception Occured while Adding crop to Database";
		}
		return msg;
		
	}
	
	@GetMapping("GetAllDisease")
	public String getAllDisease() {
		List<CropDiseases> cropdiseaseslist=this.cropdiseasesrepo.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
	        return objectMapper.writeValueAsString(cropdiseaseslist);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "Error occurred while processing JSON";
	    }
		
	}
	
	
}

