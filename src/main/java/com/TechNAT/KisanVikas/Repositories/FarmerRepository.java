package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TechNAT.KisanVikas.DAO.FarmerUser;

@Repository
public interface FarmerRepository extends MongoRepository<FarmerUser, String>{
	
    public long countByLoginDetails_Userid(String userid);
    public FarmerUser findByLoginDetails_Userid(String userid);

}
