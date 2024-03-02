package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TechNAT.KisanVikas.DAO.FarmerUser;

@Repository
public interface FarmerRepository extends MongoRepository<FarmerUser, String>{
	public long countByusrmobileno(String mobno);

}
