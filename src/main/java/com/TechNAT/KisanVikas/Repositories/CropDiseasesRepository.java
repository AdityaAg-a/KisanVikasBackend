package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TechNAT.KisanVikas.DAO.CropDiseases;

public interface CropDiseasesRepository extends MongoRepository<CropDiseases, String> {

}
