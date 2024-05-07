package com.TechNAT.KisanVikas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechNAT.KisanVikas.DAO.FarmerUser;
import com.TechNAT.KisanVikas.Repositories.FarmerRepository;

@Service
public class FarmerService {
	
	@Autowired
    private FarmerRepository farmerrepository;

	public String NewRegister() {
		
		return null;
	}
	
	 public void deleteUserByMobileNumber(String mobileNumber) {
        FarmerUser user = farmerrepository.findByLoginDetails_Userid(mobileNumber);
        if (user != null) {
            farmerrepository.delete(user);
            System.out.println("User with mobile number " + mobileNumber + " deleted successfully.");
        } else {
            System.out.println("User with mobile number " + mobileNumber + " not found.");
        }
    }
}
