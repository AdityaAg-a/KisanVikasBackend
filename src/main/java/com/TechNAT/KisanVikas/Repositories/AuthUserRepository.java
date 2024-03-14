package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TechNAT.KisanVikas.DAO.AuthUser;

@Repository
public interface AuthUserRepository extends MongoRepository<AuthUser, String>{
	public long countBymobileno(String mobno);
	public void deleteAllBymobileno(String mobno);
	public String findBymobileno(String mobno);
}
