package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TechNAT.KisanVikas.DAO.CropDetails;

public interface CropRepository extends MongoRepository<CropDetails, String> {

}
