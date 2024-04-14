package com.TechNAT.KisanVikas.Repositories;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.TechNAT.KisanVikas.DAO.FarmerUser;
import com.mongodb.client.result.UpdateResult;

@Repository
public class FarmerRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public FarmerRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

//	public String updateFieldsByMobileNumber(String mobileNumber, FarmerUser farmeruser) {
//        Query query = new Query(Criteria.where("usrmobileno").is(mobileNumber));
//        Update update = new Update()
//            .set("usrname", farmeruser.getUsrname())
//            .set("usrage", farmeruser.getUsrage())
//        	.set("usrlocation", farmeruser.getUsrlocation())
//        	.set("usrcropid", farmeruser.getUsrcropid())
//        	.set("usrsoilType", farmeruser.getUsrcropid());
//
//        UpdateResult result=mongoTemplate.updateFirst(query, update, FarmerUser.class);
//        if (result.getModifiedCount() == 0) {
//            // Handle case where no document was updated (perhaps no matching document found)
//            System.out.println("No document found for update.");
//        }
//        return "Successfully Updated";
//    }
}
